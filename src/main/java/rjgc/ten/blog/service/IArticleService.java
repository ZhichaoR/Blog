package rjgc.ten.blog.service;

import com.github.pagehelper.PageInfo;
import rjgc.ten.blog.model.domain.Article;

import java.util.List;

//文章业务详情
public interface IArticleService {
    //    根据id查询单个文章详情
   public Article selectArticleWithId(Integer id);
   //分页查询文章列表
    public PageInfo<Article> selectArticleWithPage(Integer page,Integer count);
    //统计热度前十的文章信息
    public List<Article> getHeatArticles();



}
