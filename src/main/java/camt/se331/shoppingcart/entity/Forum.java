package camt.se331.shoppingcart.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
@Entity
public class Forum {
    @Id
    @GeneratedValue
    Long id;
    String title;
    String detail;
    @ManyToOne
    Member postBy;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<CommentForum> commentForumList;
    @Temporal(TemporalType.TIMESTAMP)
    Date date;
    int status;

    public Forum() {
    }

    public Forum(Long id, String title, String detail, Member postBy, List<CommentForum> commentForumList, Date date, int status) {
        this.id=id;
        this.title = title;
        this.detail = detail;
        this.postBy = postBy;
        this.commentForumList = commentForumList;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Member getPostBy() {
        return postBy;
    }

    public void setPostBy(Member postBy) {
        this.postBy = postBy;
    }

    public List<CommentForum> getCommentForumList() {
        return commentForumList;
    }

    public void setCommentForumList(List<CommentForum> commentForumList) {
        this.commentForumList = commentForumList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFormatDate(){
        SimpleDateFormat dt1 = new SimpleDateFormat("EEE, MMM d yyyy");
        return dt1.format(getDate());
    }
}
