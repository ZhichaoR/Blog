package rjgc.ten.blog.service;

import com.github.pagehelper.PageInfo;
import rjgc.ten.blog.model.domain.Article;

import java.util.List;

//文章业务详情
public interface IArticleService {
    //   任智超： 根据id查询单个文章详情
    public Article selectArticleWithId(Integer id);

    //任智超：文章的更新
    public void updateArticleWithId(Article article);

    //秦兴旺：分页查询文章列表
    public PageInfo<Article> selectArticleWithPage(Integer page, Integer count);

    //秦兴旺：统计热度前十的文章信息
    public List<Article> getHeatArticles();


    //秦兴旺：发布文章
    public void publish(Article article);

    //秦兴旺：文章删除
    public void deleteArticleWithId(int id);
}
