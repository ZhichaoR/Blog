package rjgc.ten.blog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import rjgc.ten.blog.model.domain.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    //@Select("select * from t_comment")
//    public List<Comment> queryComment();
//    分页展示某个文章的评论
    @Select("select * from t_comment where article_id=#{aid} order by id DESC")
    public List<Comment> selectCommentWithPage(Integer aid);

    //后台查询最新几条评论
    @Select("select * from t_comment order by id DESC")
    public List<Comment> selectNewComment();

    //发表评论
    @Insert("insert into t_comment(article_id,created,author,ip,content)" +
            "Values (#{articleId},#{created},#{author},#{ip},#{content})")
    public void pushComment(Comment comment);

    //站点服务统计，统计评论数量
    @Select("select count(1) from t_comment")
    public Integer countComment();//统计评论数量

    //通过文章id删除评论信息
    @Delete("delete from t_comment where article_id=#{aid}")
    public void deleteCommentWithId(Integer aid);
}


//任智超：后续需要添加其他操作数据库的方法