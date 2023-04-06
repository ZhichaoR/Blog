package rjgc.ten.blog.dao;

import org.apache.ibatis.annotations.*;
import rjgc.ten.blog.model.domain.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
//    根据id查询文章信息
    @Select("SELECT * FROM t_article WHERE id=#{id}")
    public Article selectArticleWithId(Integer id);
//发表文章
    @Insert("INSERT INTO t_article(title,created,modified,tags,categories," +
            "allow_comment,thumbnail,content)" +
            "VALUES (#{title},#{created},#{modified},#{tags},#{categories}," +
            "#{allowComment},#{thumbnail},#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public Integer publishArticle(Article article);
//文章发分页查询
    @Select("SELECT * FROM t_article ORDER BY id DESC")
    public List<Article> selectArticleWithPage();
//通过id删除文章
    @Delete("DELETE FROM t_article WHERE id=#{id}")
    public void deleteArticleWithId(int id);
//统计文章数量
    @Select("SELECT COUNT(1) FROM t_article")
    public Integer countArticle();
//   通过id更新文章
//    @Update("UPDATE t_article SET title=#{title}, created=#{created},modified=#{modified},tags=#{tags}, categories=#{categories},allow_comment=#{allowComment},thumbnail=#{thumbnail},content=#{content} WHERE  id=#{id}")
    public Integer updateArticleWithId(Article article);

}
