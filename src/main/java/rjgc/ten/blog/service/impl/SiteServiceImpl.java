package rjgc.ten.blog.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rjgc.ten.blog.dao.ArticleMapper;
import rjgc.ten.blog.dao.CommentMapper;
import rjgc.ten.blog.dao.StatisticMapper;
import rjgc.ten.blog.model.ResponseDate.StatisticBo;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Comment;
import rjgc.ten.blog.model.domain.Statistic;
import rjgc.ten.blog.service.ISiteService;

import java.util.List;

@Service
@Transactional
public class SiteServiceImpl implements ISiteService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private StatisticMapper statisticMapper;

    @Override
    public List<Comment> recentComments(int limit) {//最新评论
        PageHelper.startPage(1, limit > 10 || limit < 1 ? 10 : limit);
        List<Comment> byPage = commentMapper.selectNewComment();
        return byPage;
    }

    @Override
    public List<Article> recentArticles(int limit) {//最新文章
        PageHelper.startPage(1, limit > 10 || limit < 1 ? 10 : limit);
        List<Article> articleList = articleMapper.selectArticleWithPage();
//        封装文章统计数据
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            Statistic statistic = statisticMapper.selectStatisticWithArticleId(article.getId());
            article.setHits(statistic.getHits());
            article.setCommentsNum(statistic.getCommentsNum());
        }
        return articleList;
    }

    @Override
    public StatisticBo getStatistics() {//获取统计文章数量以及评论数量
        StatisticBo statisticBo=new StatisticBo();
        Integer articles=articleMapper.countArticle();
        Integer comments = commentMapper.countComment();
        statisticBo.setArticles(articles);
        statisticBo.setComments(comments);
        return statisticBo;
    }

    @Override
    public void updateStatistics(Article article) {//更新统计：根据文章id找到对应的统计表里对应的statistic，然后更新其点击量
        Statistic statistic = statisticMapper.selectStatisticWithArticleId(article.getId());
        statistic.setHits(statistic.getHits()+1);
        statisticMapper.updateArticleHitWithId(statistic);
    }
}
//任智超recentComments、recentArticles、getStatistics、updateStatistics