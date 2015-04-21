package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Forum;
import camt.se331.shoppingcart.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
@Profile("db.dbdao")
@Repository
public class DbForumDao implements ForumDao {

    @Autowired
    ForumRepository forumRepository;

    @Override
    public List<Forum> getAllForum() {
        return forumRepository.findAll();
    }

    @Override
    public List<Forum> getForumByStatus(int status) {
        return null;
    }
}
