package rjgc.ten.blog.model.domain;

public class Statistic {
    private int id;
    private int articleId;
    private int hits;
    private int commentsNum;

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
