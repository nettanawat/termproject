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
    public List<Member> getMemberByStatus(int status) {
        List<Member> members = new ArrayList<Member>();
        for(Member member : getAllMember()){
            if(member.getStatus() == status){
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
    public Member deleteMember(int memberId) {
        return null;
    }

    @Override
    public Member getMemberByEmailAndPassword(String email, String password) {
        return null;
    }
}
