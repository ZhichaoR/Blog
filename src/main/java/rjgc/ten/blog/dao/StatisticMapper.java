package rjgc.ten.blog.dao;

import org.apache.ibatis.annotations.*;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Statistic;

import java.util.List;

@Mapper
public interface StatisticMapper {
//    新增文章统计信息
    @Insert("INSERT INTO t_statistic(article_id,hits,comments_num) values(#{id},0,0)")
    public void addStatistic(Article article);
//根据ID查询点击量和评论量
    @Select("SELECT * FROM t_statistic WHERE article_id=#{articleId}")
    public Statistic selectStatisticWithArticleId(Integer articleId);
//通过id更新点击量
    @Update("UPDATE t_statistic SET hits=#{hits} "
            + "WHERE article_id=#{articleId}")
    public void updateArticleHitWithId(Statistic statistic);
//通过Id更新点击量
    @Update("UPDATE t_statistic SET comments_num=#{commentsNum} " + "WHERE article_id=#{articleId}")
    public void updateArticleCommentsWithId(Statistic statistic);
//更具id删除统计数据
    @Delete("DELETE FROM t_statistic WHERE article_id=#{aid}")
    public void deleteStatisticWithId(int aid);
//统计文章热度
    @Select("SELECT * FROM t_statistic WHERE hits!='0' " + "ORDER BY hits DESC,comments_num DESC")
    public List<Statistic> getStatistic();
//    统计文章总访问量
    @Select("SELECT SUM(hits) FROM t_statistic ")
    public long getTotalVisit();
//   统计文章总评论量
    @Select("SELECT SUM(comments_num) FROM t_statistic")
    public long getTotalComment();
}
