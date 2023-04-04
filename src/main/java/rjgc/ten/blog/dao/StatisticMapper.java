package rjgc.ten.blog.dao;

import org.apache.ibatis.annotations.*;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Statistic;

import java.util.List;

@Mapper
public interface StatisticMapper {
    @Insert("INSERT INTO t_statistic(article_id,hits,comments_num) values(#{id},0,0)")
    public void addStatistic(Article article);

    @Select("SELECT * FROM t_statistic WHERE article_id=#{articleId}")
    public Statistic selectStatisticWithArticleId(Integer articleId);

    @Update("UPDATE t_statistic SET hits=#{hits} "
            + "WHERE article_id=#{articleId}")
    public void updateArticleHitWithId(Statistic statistic);

    @Update("UPDATE t_statistic SET comments_num=#{commentsNum} " + "WHERE article_id=#{articleId}")
    public void updateArticleCommentsWithId(Statistic statistic);

    @Delete("DELETE FROM t_statistic WHERE article_id=#{aid}")
    public void deleteStatisticWithId(int aid);

    @Select("SELECT * FROM t_statistic WHERE hits!='0' " + "ORDER BY hits DESC,comments_num DESC")
    public List<Statistic> getStatistic();
    @Select("SELECT SUM(hits) FROM t_statistic ")
    public long getTotalVisit();
    @Select("SELECT SUM(comments_num) FROM t_statistic")
    public long getTotalComment();
}
