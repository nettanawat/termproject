package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Event;
import camt.se331.shoppingcart.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nettanwat on 4/6/15 AD.
 */
@RestController
@RequestMapping("/")
public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping(value = "event",method = RequestMethod.GET)
    public List<Event> list(){
        return eventService.getAllEvent();
    }
}
