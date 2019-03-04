package net.slipp.member.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.slipp.member.service.Member;

@Controller
public class MemberController {
	
	private List<Member> members = new ArrayList<Member>();
	
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String joinGet(Model model) {
		return "member/join";
	}
	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String joinPost(Model model, Member member) {
		System.out.println("member : " + member);
		members.add(member);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public String listGet(Model model) {
		for (Member member : members) {
			System.out.println(member);
		}
		model.addAttribute("members", members);
		return "member/list";
	}
}
