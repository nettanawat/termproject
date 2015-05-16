package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Member;
import camt.se331.shoppingcart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nettanwat on 3/31/15 AD.
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/allmember",method = RequestMethod.GET)
    public List<Member> allMember(){
        return memberService.getAllMember();
    }

    @RequestMapping(value = "/member/{id}",method = RequestMethod.GET)
    public  Member getMemberById(@PathVariable("id") Long id){
        return memberService.getMember(id);
    }


    @RequestMapping(value = "/lastjoinedfivemembers",method = RequestMethod.GET)
    public List<Member> lastFiveJoinedMembers(){
        return memberService.getLastFiveJoinedMember();
    }

    @RequestMapping(value = "/editmember/{id}",method = RequestMethod.PUT)
    public  Member editMember(@PathVariable("id") Long id,@RequestBody Member member, BindingResult bindingResult){
        return memberService.updateMember(member);
    }

    @RequestMapping(value = "/deletemember/{id}",method = RequestMethod.DELETE)
    public Member deleteMember(@PathVariable("id") Long id){
        return memberService.deleteMember(id);
    }

    @RequestMapping(value = "/addmember",method = RequestMethod.POST)
    public @ResponseBody Member addMember(@RequestBody Member member, BindingResult bindingResult){
        return memberService.addMember(member);
    }
}
