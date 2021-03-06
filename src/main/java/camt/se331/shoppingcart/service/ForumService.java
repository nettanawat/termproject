package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.Forum;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
public interface ForumService {
    List<Forum> getAllForum();
    List<Forum> getForumByStatus(int status);
    Forum getForumById(Long id);
    List<Forum> getLastTwoForum();
    Forum deleteForum(long id);
    Forum addForum(Forum forum);
    Forum editForum(Forum forum);
}
