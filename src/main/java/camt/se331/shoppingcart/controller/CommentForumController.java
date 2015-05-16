package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.CommentForum;
import camt.se331.shoppingcart.service.CommentForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/comment/{id}",method = RequestMethod.GET)
    public CommentForum aComment(@PathVariable("id") Long id){
        return commentForumService.getCommentById(id);
    }

    @RequestMapping(value = "/deletecomment/{id}",method = RequestMethod.DELETE)
    public CommentForum delete(@PathVariable("id") Long id){
        return commentForumService.deleteComment(id);
    }

    @RequestMapping(value = "/editcomment/{id}",method = RequestMethod.PUT)
    public  CommentForum edit(@PathVariable("id") Long id,@RequestBody CommentForum commentForum, BindingResult bindingResult){
        return commentForumService.editCommentForum(commentForum);
    }

    @RequestMapping(value = "/addcomment",method = RequestMethod.POST)
    public @ResponseBody CommentForum add(@RequestBody CommentForum commentForum, BindingResult bindingResult){
        return commentForumService.addCommentForum(commentForum);
    }

}
