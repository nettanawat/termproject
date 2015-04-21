package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nettanwat on 4/12/15 AD.
 */
public interface ForumRepository extends JpaRepository<Forum, Long> {
//    List<Forum> findByIdAndStatus(Long id, int status);
}
