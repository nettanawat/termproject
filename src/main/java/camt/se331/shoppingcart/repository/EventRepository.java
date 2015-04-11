package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nettanwat on 4/6/15 AD.
 */
public interface EventRepository extends JpaRepository<Event,Long> {
}
