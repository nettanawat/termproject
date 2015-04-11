package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Event;
import camt.se331.shoppingcart.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nettanwat on 4/6/15 AD.
 */
@Profile("db.dbdao")
@Repository
public class DbEventDao implements EventDao {

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getEventByStatus(int status) {
        return null;
    }

    @Override
    public Event getEvent(Long id) {
        return null;
    }

    @Override
    public Event addEvent(Event event) {
        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public Event deleteEvent(int memberId) {
        return null;
    }
}
