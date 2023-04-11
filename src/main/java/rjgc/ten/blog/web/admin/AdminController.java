package rjgc.ten.blog.web.admin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rjgc.ten.blog.model.ResponseDate.StatisticBo;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Comment;
import rjgc.ten.blog.model.domain.Statistic;
import rjgc.ten.blog.service.ISiteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


//任智超：后台管理模块，管理员
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger=  LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private ISiteService siteServiceImpl;
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
}
