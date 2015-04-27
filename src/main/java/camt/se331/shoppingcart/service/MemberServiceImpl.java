package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.MemberDao;
import camt.se331.shoppingcart.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nettanwat on 3/31/15 AD.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao memberDao;

    @Override
    public List<Member> getAllMember() {
        return memberDao.getAllMember();
    }

    @Override
    public List<Member> getMemberByStatus(boolean status) {
        return null;
    }

    @Override
    public Member getMember(Long id) {
        return memberDao.getMember(id);
    }

    @Override
    public Member addMember(Member member) {
        return null;
    }

    @Override
    public Member updateMember(Member member) {
        return memberDao.updateMember(member);
    }

    @Override
    public Member deleteMember(int memberId) {
        return null;
    }

    @Override
    public List<Member> getLastFiveJoinedMember() {
        return memberDao.getLastFiveJoinedMember();
    }
}
