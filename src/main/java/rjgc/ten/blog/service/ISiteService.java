package rjgc.ten.blog.service;

import rjgc.ten.blog.model.ResponseDate.StatisticBo;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Comment;

import java.util.List;

//    博客站点统计服务
public interface ISiteService {
    //    最新收到的评论
    public List<Comment> recentComments(int count);

    //最新发表的文章
    public List<Article> recentArticles(int count);

    //获取后台统计数据
    public StatisticBo getStatistics();

    //    更新某个文章的统计数据
    public void updateStatistics(Article article);
}



//任智超：recentComments、recentArticles、getStatistics、updateStatistics