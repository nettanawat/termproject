package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.CommentForumDao;
import camt.se331.shoppingcart.entity.CommentForum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
@Service
public class CommentForumServiceImpl implements CommentForumService {

    @Autowired
    CommentForumDao commentForumDao;

    @Override
    public List<CommentForum> getAllComment() {
        return commentForumDao.getAllComment();
    }

    @Override
    public List<CommentForum> getCommentByStatus(boolean status) {
        return commentForumDao.getCommentByStatus(status);
    }

    @Override
    public CommentForum getCommentById(long id) {
        return commentForumDao.getCommentById(id);
    }

    @Override
    public CommentForum deleteComment(long id) {
        CommentForum commentForum = getCommentById(id);
        return commentForumDao.deleteComment(commentForum);
    }

    @Override
    public CommentForum addCommentForum(CommentForum commentForum) {
        return commentForumDao.addCommentForum(commentForum);
    }

    @Override
    public CommentForum editCommentForum(CommentForum commentForum) {
        return commentForumDao.editCommentForum(commentForum);
    }
}
