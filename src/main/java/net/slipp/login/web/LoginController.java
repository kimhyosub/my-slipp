package net.slipp.login.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.slipp.common.util.HttpSessionUtil;
import net.slipp.member.domain.Member;
import net.slipp.member.domain.MemberRepository;

@Controller
public class LoginController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/login/form")
	public String form() {
		return "/login/form";
	}
	
	@PostMapping("/login")
	public String login(String memberId, String memberPassword, HttpSession session) {
		Member member = memberRepository.findByMemberId(memberId);
		if(member == null) {
			System.out.println("Login Failure!1");
			return "redirect:/login/form";
		}
		
		if(!member.matchPassword(memberPassword)) {
			System.out.println("Login Failure!");
			return "redirect:/login/form";
		}
		
		System.out.println("Login Success!");
				
		session.setAttribute(HttpSessionUtil.USER_SESSION_KEY, member);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(HttpSessionUtil.USER_SESSION_KEY);
		return "redirect:/";
	}
	
	
}
