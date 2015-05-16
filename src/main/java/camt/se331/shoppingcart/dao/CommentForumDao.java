package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.CommentForum;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
public interface CommentForumDao {
    List<CommentForum> getAllComment();
    List<CommentForum> getCommentByStatus(boolean status);
    CommentForum deleteComment(CommentForum commentForum);
    CommentForum getCommentById(Long id);
    CommentForum addCommentForum(CommentForum commentForum);
    CommentForum editCommentForum(CommentForum commentForum);
}
