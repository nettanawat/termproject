package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.CommentForum;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
public interface CommentForumDao {
    List<CommentForum> getAllComment();
    List<CommentForum> getCommentByStatus(int status);
}
