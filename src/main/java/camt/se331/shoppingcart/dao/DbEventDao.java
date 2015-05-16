package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Event;
import camt.se331.shoppingcart.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

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
    public List<Event> getEventByStatus(boolean status) {
        return eventRepository.findByStatus(status);
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findOne(id);
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event deleteEvent(Event event) {
        eventRepository.delete(event);
        event.setId(null);
        return event;
    }

    @Override
    public List<Event> getRandomThreeEvents() {
        int eventSize = eventRepository.findAll().size()-1;
        Random rand = new Random();
        List<Event> events = new ArrayList<Event>();
        int[] randomPosition = new int[3];
        for(int i =0; i < 3; i++){
            randomPosition[i] = rand.nextInt(((eventSize-1) - 1) + 1) + 1;
        }
        while (randomPosition[0] == randomPosition[1]){
            randomPosition[1] = rand.nextInt(((eventSize-1) - 1) + 1) + 1;
        }
        while (randomPosition[0] == randomPosition[2]){
            randomPosition[2] = rand.nextInt(((eventSize-1) - 1) + 1) + 1;
        }
        while (randomPosition[1] == randomPosition[2]){
            randomPosition[2] = rand.nextInt(((eventSize-1) - 1) + 1) + 1;
        }
        events.add(eventRepository.findAll().get(randomPosition[0]));
        events.add(eventRepository.findAll().get(randomPosition[1]));
        events.add(eventRepository.findAll().get(randomPosition[2]));
        return events;
    }

    @Override
    public Event getEventByNearestDate() {
        Calendar cal = Calendar.getInstance();
        return eventRepository.findTop1ByDateGreaterThanOrderByDateDesc(cal.getTime());
    }
}
