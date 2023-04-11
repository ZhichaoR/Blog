package rjgc.ten.blog.web.client;

import com.vdurmont.emoji.EmojiParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import rjgc.ten.blog.model.ResponseDate.ArticleResponseData;
import rjgc.ten.blog.model.domain.Comment;
import rjgc.ten.blog.service.ICommentService;
import rjgc.ten.blog.utils.MyUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//发布评论的请求处理层的实现
//郭子昀：评论控制类
@Controller
@RequestMapping("/comments")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private ICommentService commentServcieImpl;

    // 发表评论操作
    @PostMapping(value = "/publish")
    @ResponseBody
    public ArticleResponseData publishComment(HttpServletRequest request, @RequestParam Integer aid, @RequestParam String text) {
        // 去除js脚本
        text = MyUtils.cleanXSS(text);
        text = EmojiParser.parseToAliases(text);
        // 获取当前登录用户
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 封装评论信息
        Comment comments = new Comment();
        comments.setArticleId(aid);
        comments.setIp(request.getRemoteAddr());
        comments.setCreated(new Date());
        comments.setAuthor(user.getUsername());
        comments.setContent(text);
        try {
            commentServcieImpl.pushComment(comments);
            logger.info("发布评论成功，对应文章id: "+aid);
            return ArticleResponseData.ok();
        } catch (Exception e) {
            logger.error("发布评论失败，对应文章id: "+aid +";错误描述: "+e.getMessage());
            return ArticleResponseData.fail();
        }
    }
}
//publishComment()方法用于实现发布评论，处理路径为"/comments/publish"的请求。
//如果用户发布评论，首先会获取并封装用户的评论信息，然后将评论信息插入数据库，最后根据数据库操作结果提示用户是否成功发布评论