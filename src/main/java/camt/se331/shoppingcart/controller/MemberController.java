package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Member;
import camt.se331.shoppingcart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nettanwat on 3/31/15 AD.
 */
@RestController
@RequestMapping("/")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "member",method = RequestMethod.GET)
    public List<Member> list(){
        return memberService.getAllMember();
    }

    @RequestMapping(value = "lasttwomember",method = RequestMethod.GET)
    public List<Member> lastTwo(){
        List<Member> result = new ArrayList<Member>();
        for(int i=2; i<memberService.getAllMember().size();i++){
            result.add(memberService.getAllMember().get(i));
        }
        return result;
    }
}
