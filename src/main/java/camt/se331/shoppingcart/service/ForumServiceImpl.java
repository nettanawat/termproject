package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.ForumDao;
import camt.se331.shoppingcart.entity.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    ForumDao forumDao;

    @Override
    public List<Forum> getAllForum() {
        return forumDao.getAllForum();
    }

    @Override
    public List<Forum> getForumByStatus(int status) {
        return forumDao.getForumByStatus(status);
    }

    @Override
    public Forum getForumById(Long id) {
        return forumDao.getForumById(id);
    }

    @Override
    public List<Forum> getLastTwoForum() {
        return forumDao.getLastTwoForum();
    }


}
