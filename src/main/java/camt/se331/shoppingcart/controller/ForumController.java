package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Forum;
import camt.se331.shoppingcart.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    ForumService forumService;

    @RequestMapping(value = "/allforum",method = RequestMethod.GET)
    public List<Forum> list(){
        return forumService.getAllForum();
    }

    @RequestMapping(value = "/forumById/{id}",method = RequestMethod.GET)
    public  Forum getForum(@PathVariable("id") Long id){
        return forumService.getForumById(id);
    }
}
