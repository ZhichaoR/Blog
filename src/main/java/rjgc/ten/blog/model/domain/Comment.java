package rjgc.ten.blog.model.domain;


import java.util.Date;

//任智超
public class Comment {
    private Integer id;
    private Integer articleId;
    private Date created;
    private String ip;
    private String content;
    private String status;
    private String author;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", created=" + created +
                ", ip='" + ip + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
