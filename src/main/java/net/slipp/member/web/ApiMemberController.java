package net.slipp.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.slipp.member.domain.Member;
import net.slipp.member.domain.MemberRepository;

@RestController
@RequestMapping("/api/member")
public class ApiMemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/{id}")
	public Member show(@PathVariable Long id) {
		return memberRepository.getOne(id);
	}
}
