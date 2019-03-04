package net.slipp.member.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.slipp.member.domain.Member;
import net.slipp.member.domain.MemberRepository;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String joinGet(Model model) {
		return "member/join";
	}
	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String joinPost(Model model, Member member) {
		System.out.println("member : " + member);
		memberRepository.save(member);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public String listGet(Model model) {
		model.addAttribute("members", memberRepository.findAll());
		return "member/list";
	}
}
