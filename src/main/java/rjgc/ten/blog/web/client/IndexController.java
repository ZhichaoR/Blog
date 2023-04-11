package rjgc.ten.blog.web.client;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import rjgc.ten.blog.model.domain.Article;
import rjgc.ten.blog.model.domain.Comment;
import rjgc.ten.blog.service.IArticleService;
import rjgc.ten.blog.service.ICommentService;
import rjgc.ten.blog.service.ISiteService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private ICommentService commentServiceImpl;
    @Autowired
    private ISiteService siteServiceImpl;
    @Autowired
    private IArticleService articleServiceImpl;

    //任智超：文章详情查询
    @GetMapping(value = "/article/{id}")
    public String getArticleById(@PathVariable("id") Integer id,
                                 HttpServletRequest request) {
        Article article = articleServiceImpl.selectArticleWithId(id);
        if (article != null) {
            getArticleComments(request,article);
            request.setAttribute("article",article);
            return "client/articleDetails";
        }else {
            logger.warn("查询文章详情结果为空，查询文章id: "+id);
            // 未找到对应文章页面，跳转到提示页
            return "comm/error_404";
        }
    }
//任智超：
    private void getArticleComments(HttpServletRequest request, Article article) {
        if (article.getAllowComment()) {
            String cp = request.getParameter("cp");
            cp = StringUtils.isBlank(cp) ? "1" : cp;
            request.setAttribute("cp", cp);
            PageInfo<Comment> comments = commentServiceImpl.getComments(article.getId(), Integer.parseInt(cp), 3);
            request.setAttribute("cp", cp);
            request.setAttribute("comments", comments);
        }
    }

    // 秦兴旺:博客首页，会自动跳转到文章页
    @GetMapping(value = "/")
    private String index(HttpServletRequest request) {
        return this.index(request, 1, 5);
    }

    // 秦兴旺：文章页
    @GetMapping(value = "/page/{p}")
    public String index(HttpServletRequest request, @PathVariable("p") int page, @RequestParam(value = "count", defaultValue = "5") int count) {
        PageInfo<Article> articles = articleServiceImpl.selectArticleWithPage(page, count);
        // 获取文章热度统计信息
        List<Article> articleList = articleServiceImpl.getHeatArticles();
        request.setAttribute("articles", articles);
        request.setAttribute("articleList", articleList);
        logger.info("分页获取文章信息: 页码 "+page+",条数 "+count);
        return "client/index";
    }
}
