package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.MemberDao;
import camt.se331.shoppingcart.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
        Calendar cal = new GregorianCalendar();
        member.setJoinDate(cal.getTime());
        member.setStatus(true);
        member.setRole("USER");
        return memberDao.addMember(member);
    }

    @Override
    public Member updateMember(Member member) {
        return memberDao.updateMember(member);
    }

    @Override
    public Member deleteMember(long memberId) {
        Member member = getMember(memberId);
        return memberDao.deleteMember(member);
    }

    @Override
    public List<Member> getLastFiveJoinedMember() {
        return memberDao.getLastFiveJoinedMember();
    }
}
