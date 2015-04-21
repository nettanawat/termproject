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
    public List<CommentForum> getCommentByStatus(int status) {
        return null;
    }
}
