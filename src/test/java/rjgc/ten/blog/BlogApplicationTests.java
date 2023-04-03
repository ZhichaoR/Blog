package rjgc.ten.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rjgc.ten.blog.dao.CommentMapper;
import rjgc.ten.blog.model.domain.Comment;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private CommentMapper commentMapper;

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
