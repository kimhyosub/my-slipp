package net.slipp.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.common.util.HttpSessionUtil;
import net.slipp.member.domain.Member;
import net.slipp.member.domain.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/form")
	public String form(Model model) {
		return "member/form";
	}
	
	@GetMapping("/{id}/form")
	public String updateForm(Model model, @PathVariable Long id, HttpSession session) {
		if(HttpSessionUtil.isLoginMember(session)) {
			return "redirect:/login/form";
		}
		
		Member sessionedMember = HttpSessionUtil.getMemberFromSession(session);
		if(!sessionedMember.matchId(id)) {
			throw new IllegalStateException("You can't update the anther Member");
		}
		
		Member member = memberRepository.getOne(id);
		model.addAttribute("isUpdate", true);
		model.addAttribute("member", member);
		return "member/form";
	}
	
	@PostMapping("/form")
	public String update(Model model, Member member, HttpSession session) {
		if(HttpSessionUtil.isLoginMember(session)) {
			return "redirect:/login/form";
		}
		
		Member sessionedMember = HttpSessionUtil.getMemberFromSession(session);
		if(!sessionedMember.matchId(member.getId())) {
			throw new IllegalStateException("You can't update the anther Member");
		}
		
		memberRepository.save(member);
		return "redirect:/member/list";
	}
	
	@GetMapping("/list")
	public String listGet(Model model) {
		model.addAttribute("members", memberRepository.findAll());
		return "member/list";
	}
}
