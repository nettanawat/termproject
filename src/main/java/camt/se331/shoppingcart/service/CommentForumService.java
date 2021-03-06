package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.CommentForum;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
public interface CommentForumService {
    List<CommentForum> getAllComment();
    List<CommentForum> getCommentByStatus(boolean status);
    CommentForum getCommentById(long id);
    CommentForum deleteComment(long id);
    CommentForum addCommentForum(CommentForum commentForum);
    CommentForum editCommentForum(CommentForum commentForum);
}
