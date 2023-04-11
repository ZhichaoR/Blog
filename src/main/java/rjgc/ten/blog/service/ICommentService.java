package rjgc.ten.blog.service;

import com.github.pagehelper.PageInfo;
import rjgc.ten.blog.model.domain.Comment;

//文章评论业务处理接口
public interface ICommentService {
    //  任智超：  获取文章下的评论
    public PageInfo<Comment> getComments(Integer aid, int page, int count);

    //    郭子昀：发表评论
    public void pushComment(Comment comment);
}
