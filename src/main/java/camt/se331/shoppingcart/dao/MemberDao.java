package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Member;

import java.util.List;

/**
 * Created by nettanwat on 3/31/15 AD.
 */
public interface MemberDao {

    List<Member> getAllMember();
    List<Member> getMemberByStatus(int status);
    Member getMember(Long id);
    Member addMember(Member member);
    Member updateMember(Member member);
    Member deleteMember(int memberId);
    Member getMemberByEmailAndPassword(String email, String password);
 }
