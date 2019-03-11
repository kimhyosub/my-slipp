package net.slipp.question.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.common.domain.Result;
import net.slipp.common.util.HttpSessionUtil;
import net.slipp.member.domain.Member;
import net.slipp.question.domain.Question;
import net.slipp.question.domain.QuestionRepository;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/form")
	public String form(HttpSession session) {
		if(!HttpSessionUtil.isLoginMember(session)) {
			return "redirect:/login/form";
		}
		return "/qna/form";
	}
	
	@PostMapping("")
	public String insert(String title, String contents, HttpSession session) {
		if(!HttpSessionUtil.isLoginMember(session)) {
			return "redirect:/login/form";
		}
		
		Member sessionedMember = HttpSessionUtil.getMemberFromSession(session);
		Question question = new Question(sessionedMember, title, contents);
		
		questionRepository.save(question);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable Long id) {
		model.addAttribute("question", questionRepository.getOne(id)) ;
		return "/qna/show";
	}
	
	@GetMapping("/{id}/form")
	public String updateForm(Model model, @PathVariable Long id, HttpSession session) {
		Question question = questionRepository.getOne(id);
		Result result = valid(session, question);
		if(!result.isValid()) {
			model.addAttribute("errorMessage", result.getErrorMessage());
			return "/login/form";
		}
		
		model.addAttribute("question", question);
		return"/qna/updateForm";
	}
	
	@PutMapping("/{id}")
	public String update(Model model, @PathVariable Long id, String title, String contents, HttpSession session) {
		Question question = questionRepository.getOne(id);
		Result result = valid(session, question);
		if(!result.isValid()) {
			model.addAttribute("errorMessage", result.getErrorMessage());
			return "/login/form";
		}
		
		question.update(title, contents);
		questionRepository.save(question);
		return String.format("redirect:/question/%d", id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(Model model, @PathVariable Long id, HttpSession session) {
		Question question = questionRepository.getOne(id);
		Result result = valid(session, question);
		if(!result.isValid()) {
			model.addAttribute("errorMessage", result.getErrorMessage());
			return "/login/form";
		}
		
		questionRepository.deleteById(id);
		return "redirect:/";
	}
	
	private Result valid(HttpSession session, Question question) {
		if(!HttpSessionUtil.isLoginMember(session)) {
			return Result.fail("로그인이 필요합니다.");
		}
		
		Member loginMember = HttpSessionUtil.getMemberFromSession(session);
		if(!question.isSameWriter(loginMember)) {
			return Result.fail("자신이 쓴 글만 수정, 삭제가 가능합니다.");
		}
		
		return Result.ok();
	}
}
