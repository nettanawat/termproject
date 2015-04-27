package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Forum;
import camt.se331.shoppingcart.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
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

    @Override
    public Forum getForumById(Long id) {
        return forumRepository.findOne(id);
    }

    @Override
    public List<Forum> getLastTwoForum() {
        return forumRepository.findTop2ByOrderByIdDesc();
    }

    @Override
    public List<Forum> getTopFiveCommentedForum() {
        List<Forum> forums = new ArrayList<Forum>();
        for(int i=0; i<forumRepository.findAll().size();i++){

        }

        return null;
    }

}
