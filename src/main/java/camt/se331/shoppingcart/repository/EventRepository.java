package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by nettanwat on 4/6/15 AD.
 */
public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAllByOrderByDateAsc();
    Event findTop1ByOrderByDateDesc();
    Event findTop1ByDateGreaterThanOrderByDateDesc(Date date);
    List<Event> findByStatus(boolean status);
}
