package rjgc.ten.blog;

import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rjgc.ten.blog.dao.ArticleMapper;
import rjgc.ten.blog.dao.CommentMapper;
import rjgc.ten.blog.model.ResponseDate.StatisticBo;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Comment;
import rjgc.ten.blog.service.impl.CommentServiceImpl;
import rjgc.ten.blog.service.impl.SiteServiceImpl;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SiteServiceImpl siteService;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentServiceImpl commentService;

    //测试CommentServiceImpl当中的getComments方法，并且打印输出
    @Test
    public void getCommentsTest() {
        PageInfo<Comment> commentPageInfo = commentService.getComments(1, 1, 5);
        System.out.println(commentPageInfo);
    }

    //测试根据文章id来进行点击量的增加操作
    @Test
    public void updateStatisticsTest() {
        Article article = new Article();
        article = articleMapper.selectArticleWithId(1);
        siteService.updateStatistics(article);
    }

    //测试获取统计文章的数据
    @Test
    public void getStatisticsTest() {
        StatisticBo statisticBo = siteService.getStatistics();
        System.out.println(articleMapper.countArticle());
        System.out.println(statisticBo);
    }

    //测试找到最新的文章
    @Test
    public void recentArticlesTest() {
        List<Article> articleList = siteService.recentArticles(7);
        System.out.println(articleList);
    }

    //    测试查找最新的五条评论数据
    @Test
    public void recentCommentsTest() {
        List<Comment> commentList = siteService.recentComments(5);
        System.out.println(commentList);
    }

    //    任智超：测试deleteCommentWithId()
    @Test
    public void deleteCommentWithIdTest() {
        commentMapper.deleteCommentWithId(21);
    }

    //    任智超：测试countComment()
    @Test
    public void countCommentTest() {
        Integer count = commentMapper.countComment();
        System.out.println(count);
    }

    //任智超：测试pushComment()
    @Test
    public void pushCommentTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(simpleDateFormat.format(date));
        Comment comment = new Comment();
        comment.setCreated(date);
        comment.setContent("测试pushComment");
        comment.setAuthor("任智超");
        comment.setArticleId(21);
        commentMapper.pushComment(comment);
    }

    //任智超：测试selectNewComment()
    @Test
    public void selectNewCommentTest() {
        List<Comment> comments = commentMapper.selectNewComment();
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }


    //    任智超：测试selectCommentWithPage()
    @Test
    public void selectCommentWithPageTest() {
        List<Comment> comments = commentMapper.selectCommentWithPage(1);
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }

    //    任智超：初步逻辑测试
//@Test
//public void mapperTest(){
//    List<Comment> comments=commentMapper.queryComment();
//    for(Comment comment:comments){
//        System.out.println(comment);
//    }
//}
    @Test
    void contextLoads() {
    }

}
