package net.slipp.answer.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.slipp.answer.domain.Answer;
import net.slipp.answer.domain.AnswerRepository;
import net.slipp.common.domain.Result;
import net.slipp.common.util.HttpSessionUtil;
import net.slipp.member.domain.Member;
import net.slipp.question.domain.Question;
import net.slipp.question.domain.QuestionRepository;

@RestController
@RequestMapping("/api/question/{questionId}/answers")
public class ApiAnswerController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@PostMapping("")
	public Answer create(@PathVariable Long questionId, String contents, HttpSession session) {
		if(!HttpSessionUtil.isLoginMember(session)) {
			return null;
		}
		
		Member loginMember = HttpSessionUtil.getMemberFromSession(session);
		Question question = questionRepository.getOne(questionId);
		Answer answer = new Answer(loginMember, question, contents);
		question.addAnswer();
		return answerRepository.save(answer);
	}
	
	@DeleteMapping("{id}")
	public Result delete(@PathVariable Long questionId, @PathVariable Long id, HttpSession session) {
		if (!HttpSessionUtil.isLoginMember(session)) {
			return Result.fail("로그인 해야합니다");
		}
		
		Answer answer = answerRepository.getOne(id);
		Member loginMember = HttpSessionUtil.getMemberFromSession(session);
		if (!answer.isSameWriter(loginMember)) {
			return Result.fail("자신의 글만 삭제할 수 있습니다.");
		}
		
		answerRepository.deleteById(id);
		
		Question question = questionRepository.getOne(questionId);
		question.deleteAnswer();
		questionRepository.save(question);
		return Result.ok();
	}
	
}
