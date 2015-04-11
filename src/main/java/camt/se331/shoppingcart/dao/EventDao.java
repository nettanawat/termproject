package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Event;

import java.util.List;

/**
 * Created by nettanwat on 4/6/15 AD.
 */
public interface EventDao {
    List<Event> getAllEvent();
    List<Event> getEventByStatus(int status);
    Event getEvent(Long id);
    Event addEvent(Event event);
    Event updateEvent(Event event);
    Event deleteEvent(int memberId);
}
