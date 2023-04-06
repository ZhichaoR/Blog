package rjgc.ten.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rjgc.ten.blog.dao.ArticleMapper;
import rjgc.ten.blog.dao.StatisticMapper;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Statistic;
import rjgc.ten.blog.service.IArticleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private StatisticMapper statisticMapper;

    @Override
    public Article selectArticleWithId(Integer id) {
        return null;
    }
    //分页查询文章列表
    @Override
    public PageInfo<Article> selectArticleWithPage(Integer page, Integer count) {
        PageHelper.startPage(page, count);
        List<Article> articleList = articleMapper.selectArticleWithPage();
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            Statistic statistic = statisticMapper.selectStatisticWithArticleId(article.getId());
            article.setHits(statistic.getHits());
            article.setCommentsNum(statistic.getCommentsNum());
        }
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        return pageInfo;
    }
    //统计热度前十的文章信息
    @Override
    public List<Article> getHeatArticles() {

        List<Statistic> list=statisticMapper.getStatistic();
        List<Article> articlelist=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Article article=articleMapper.selectArticleWithId(list.get(i).getArticleId());
            article.setHits(list.get(i).getHits());
            article.setCommentsNum(list.get(i).getCommentsNum());
            articlelist.add(article);
            if(i>=9){
                break;
            }
            return articlelist;
        }


        return null;
    }
}
