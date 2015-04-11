package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nettanwat on 3/31/15 AD.
 */
public interface MemberRepository extends JpaRepository<Member,Long> {
}
