package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
public interface ForumRepository extends JpaRepository<Forum, Long> {
    List<Forum> findAllByOrderByIdDesc();
    List<Forum> findTop2ByOrderByIdDesc();

}
