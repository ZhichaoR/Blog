package rjgc.ten.blog.web.admin;


import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rjgc.ten.blog.model.ResponseDate.ArticleResponseData;
import rjgc.ten.blog.model.ResponseDate.StatisticBo;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Comment;
import rjgc.ten.blog.model.domain.Statistic;
import rjgc.ten.blog.service.IArticleService;
import rjgc.ten.blog.service.ISiteService;
import rjgc.ten.blog.service.impl.ArticleServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


//任智超：后台管理模块，管理员
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger=  LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private ISiteService siteServiceImpl;
    @Autowired
    private IArticleService articleServiceImpl;
    //    管理中心起始页
    @GetMapping(value = {"","/index"})
    public String index(HttpServletRequest request){
//        获取最新的五篇博客、评论以及统计数据
        List<Article> articles=siteServiceImpl.recentArticles(5);
        List<Comment>comments=siteServiceImpl.recentComments(5);
        StatisticBo statisticBo=siteServiceImpl.getStatistics();
//        向request存储数据
        request.setAttribute("comments",comments);
        request.setAttribute("articles",articles);
        request.setAttribute("statisticBo",statisticBo);
        return "back/index";
    }
    //秦兴旺： 向文章发表页面跳转
    @GetMapping(value = "/article/toEditPage")
    public String newArticle( ) {
        return "back/article_edit";
    }
    // 发表文章
    @PostMapping(value = "/article/publish")
    @ResponseBody
    public ArticleResponseData publishArticle(Article article) {
        if (StringUtils.isBlank(article.getCategories())) {
            article.setCategories("默认分类");
        }
        try {
            articleServiceImpl.publish(article);
            logger.info("文章发布成功");
            return ArticleResponseData.ok();
        } catch (Exception e) {
            logger.error("文章发布失败，错误信息: "+e.getMessage());
            return ArticleResponseData.fail();
        }
    }
    //秦兴旺： 跳转到后台文章列表页面
    @GetMapping(value = "/article")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "count", defaultValue = "10") int count,
                        HttpServletRequest request) {
        PageInfo<Article> pageInfo = articleServiceImpl.selectArticleWithPage(page, count);
        request.setAttribute("articles", pageInfo);
        return "back/article_list";
    }
}
