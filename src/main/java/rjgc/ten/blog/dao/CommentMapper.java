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
    @Select("select * from t_comment where article_id=#{aid} order by id DESC")
    public List<Comment> selectCommentWithPage(Integer aid);
    @Select("select * from t_comment order by id DESC")
    public List<Comment> selectNewComment();
    @Insert("insert into t_comment(article_id,created,author,ip,content)"+
    "Values (#{articleId},#{created},#{author},#{ip},#{content})")
    public void pushComment(Comment comment);
    @Select("select count(1) from t_comment")
    public Integer countComment();//统计评论数量
    @Delete("delete from t_comment where article_id=#{aid}")
    public void deleteCommentWithId(Integer aid);
}
