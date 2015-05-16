package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Member;
import camt.se331.shoppingcart.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nettanwat on 3/31/15 AD.
 */

@Profile("db.dbdao")
@Repository

public class DbMemberDao implements MemberDao {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> getMemberByStatus(boolean status) {
        List<Member> members = new ArrayList<Member>();
        for(Member member : getAllMember()){
            if(member.isStatus() == status){
                members.add(member);
            }
        }
        return members;
    }

    @Override
    public Member getMember(Long id) {
        return memberRepository.findOne(id);
    }

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member deleteMember(Member member) {
        member.setStatus(false);
        return memberRepository.save(member);
//        memberRepository.delete(member);
//        return member;
    }

    @Override
    public Member getMemberByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public List<Member> getLastFiveJoinedMember() {
        return memberRepository.findTop5ByOrderByJoinDateDesc();
    }
}
