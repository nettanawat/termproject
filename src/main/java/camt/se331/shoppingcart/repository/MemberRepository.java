package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nettanwat on 3/31/15 AD.
 */
public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findTop5ByOrderByJoinDateDesc();
}
