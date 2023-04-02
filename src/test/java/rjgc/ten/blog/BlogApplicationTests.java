package rjgc.ten.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rjgc.ten.blog.dao.CommentMapper;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private CommentMapper commentMapper;
@Test
public void mapperTest(){
    commentMapper.selectCommentWithPage(1);
}
    @Test
    void contextLoads() {
    }

}
