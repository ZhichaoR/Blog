package rjgc.ten.blog.service;

import rjgc.ten.blog.model.domain.Article;

//文章业务详情
public interface IArticleService {
    //    根据id查询单个文章详情
    public Article selectArticleWithId(Integer id);
}
