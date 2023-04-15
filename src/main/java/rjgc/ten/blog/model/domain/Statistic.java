package rjgc.ten.blog.model.domain;

public class Statistic {
    private Integer id;
    private Integer articleId;   // 评论的文章id
    private Integer hits;        // 点击量
    private Integer commentsNum;// 评论总量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(int commentsNum) {
        this.commentsNum = commentsNum;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", hits=" + hits +
                ", commentsNum=" + commentsNum +
                '}';
    }
}
