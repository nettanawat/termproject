package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Event;
import camt.se331.shoppingcart.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nettanwat on 4/6/15 AD.
 */
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping(value = "/allevents",method = RequestMethod.GET)
    public List<Event> getAllEvents(){
        return eventService.getAllEvent();
    }

    @RequestMapping(value = "/randomthreeevents",method = RequestMethod.GET)
    public List<Event> getRandomThreeEvent(){
        return eventService.getRandomThreeEvents();
    }

    @RequestMapping(value = "/upcomingevent",method = RequestMethod.GET)
    public Event getUpComingEvent(){
        return eventService.getEventByNearestDate();
    }

    @RequestMapping(value = "/eventbyid/{id}",method = RequestMethod.GET)
    public  Event getEventById(@PathVariable("id") Long id){

        return eventService.getEvent(id);
    }

    @RequestMapping(value = "/editevent/{id}",method = RequestMethod.PUT)
    public  Event edit(@PathVariable("id") Long id,@RequestBody Event event, BindingResult bindingResult){
        return eventService.updateEvent(event);
    }
}
