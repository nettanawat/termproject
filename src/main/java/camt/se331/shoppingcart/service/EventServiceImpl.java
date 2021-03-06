package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.EventDao;
import camt.se331.shoppingcart.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nettanwat on 4/6/15 AD.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDao eventDao;

    @Override
    public List<Event> getAllEvent() {
        return eventDao.getAllEvent();
    }

    @Override
    public List<Event> getEventByStatus(int status) {
        return null;
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    public Event addEvent(Event event) {
        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDao.updateEvent(event);
    }

    @Override
    public Event deleteEvent(long id) {
        return null;
    }

    @Override
    public List<Event> getRandomThreeEvents() {
        return eventDao.getRandomThreeEvents();
    }

    @Override
    public Event getEventByNearestDate() {
        return eventDao.getEventByNearestDate();
    }
}
