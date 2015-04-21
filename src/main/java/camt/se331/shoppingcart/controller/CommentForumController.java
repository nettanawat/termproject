package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.CommentForum;
import camt.se331.shoppingcart.service.CommentForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
@RestController
@RequestMapping("/comment")
public class CommentForumController {

    @Autowired
    CommentForumService commentForumService;

    @RequestMapping(value = "/allcomment",method = RequestMethod.GET)
    public List<CommentForum> list(){
        return commentForumService.getAllComment();
    }
}
