package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Member;

import java.util.List;

/**
 * Created by nettanwat on 3/31/15 AD.
 */
public interface MemberDao {

    List<Member> getAllMember();
    List<Member> getMemberByStatus(boolean status);
    Member getMember(Long id);
    Member addMember(Member member);
    Member updateMember(Member member);
    Member deleteMember(Member member);
    Member getMemberByEmailAndPassword(String email, String password);
    List<Member> getLastFiveJoinedMember();
 }
