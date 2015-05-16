package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Forum;
import camt.se331.shoppingcart.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public List<Forum> getAllForum(){
        return forumService.getAllForum();
    }

    @RequestMapping(value = "/forumById/{id}",method = RequestMethod.GET)
    public  Forum getForumById(@PathVariable("id") Long id){
        return forumService.getForumById(id);
    }

    @RequestMapping(value = "/lasttwoforum",method = RequestMethod.GET)
    public  List<Forum> getLastTwoForum(){
        return forumService.getLastTwoForum();
    }

    @RequestMapping(value = "/deleteforum/{id}",method = RequestMethod.DELETE)
    public Forum deleteForum(@PathVariable("id") Long id){
        return forumService.deleteForum(id);
    }

    @RequestMapping(value = "/editforum/{id}",method = RequestMethod.PUT)
    public  Forum editForum(@PathVariable("id") Long id,@RequestBody Forum forum, BindingResult bindingResult){
        return forumService.editForum(forum);
    }

    @RequestMapping(value = "/addforum",method = RequestMethod.POST)
    public @ResponseBody Forum addForum(@RequestBody Forum forum, BindingResult bindingResult){
        return forumService.addForum(forum);
    }
}
