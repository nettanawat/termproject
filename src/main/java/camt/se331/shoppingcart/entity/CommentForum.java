package camt.se331.shoppingcart.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nettanwat on 4/12/15 AD.
 */

@Entity
public class CommentForum {
    @Id
    @GeneratedValue
    private Long id;
    private String detail;
    @ManyToOne
    private Member commentBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private boolean status;

    public CommentForum() {
    }

    public CommentForum(Long id,String detail, Member commentBy, Date date, boolean status) {
        this.id = id;
        this.detail = detail;
        this.commentBy = commentBy;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Member getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(Member commentBy) {
        this.commentBy = commentBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFormatDate(){
        SimpleDateFormat dt1 = new SimpleDateFormat("EEE, MMM d yyyy 'at' HH:mm:ss");
        return dt1.format(getDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentForum that = (CommentForum) o;

        if (status != that.status) return false;
        if (commentBy != null ? !commentBy.equals(that.commentBy) : that.commentBy != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (commentBy != null ? commentBy.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }
}
