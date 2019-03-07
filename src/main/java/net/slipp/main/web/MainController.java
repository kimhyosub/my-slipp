package net.slipp.main.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.question.domain.QuestionRepository;

@Controller
public class MainController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@RequestMapping("/")
	public String index(Model model){
		
		model.addAttribute("questions", questionRepository.findAll());
		return "index";
	}

}
