package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.CommentForum;
import camt.se331.shoppingcart.repository.CommentForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
@Profile("db.dbdao")
@Repository
public class DbCommentForumDao implements CommentForumDao {

    @Autowired
    CommentForumRepository commentForumRepository;

    @Override
    public List<CommentForum> getAllComment() {
        return commentForumRepository.findAll();
    }

    @Override
    public List<CommentForum> getCommentByStatus(boolean status) {
        return null;
    }

    @Override
    public CommentForum deleteComment(CommentForum commentForum) {
        commentForum.setDetail("This comment has been removed by administrator due to maintain of conversation of other members.");
        commentForum.setStatus(false);
        return commentForumRepository.save(commentForum);
    }

    @Override
    public CommentForum getCommentById(Long id) {
        return commentForumRepository.findOne(id);
    }

    @Override
    public CommentForum addCommentForum(CommentForum commentForum) {
        return commentForumRepository.save(commentForum);
    }

    @Override
    public CommentForum editCommentForum(CommentForum commentForum) {
        return commentForumRepository.save(commentForum);
    }
}
