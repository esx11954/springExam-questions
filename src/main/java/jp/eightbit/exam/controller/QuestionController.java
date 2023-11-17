package jp.eightbit.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.eightbit.exam.entity.Questions;
import jp.eightbit.exam.model.QuestionModel;
import jp.eightbit.exam.model.QuestionResult;
import jp.eightbit.exam.service.QuestionService;


@Controller
public class QuestionController {
	
	@Autowired
	private HttpSession session;
	
	private final QuestionService questionService;
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping("/")
	public String routeToIndex(Model model) {
		QuestionModel questionModel = (QuestionModel) session.getAttribute("questionModel");
		if (questionModel != null) session.invalidate();
		model.addAttribute("questionModel", new QuestionModel());
		return "index";
	}
	
	@PostMapping("/nameCheck")
	public String toQuestion1(Model model, @Valid @ModelAttribute QuestionModel questionModel, BindingResult bindingResult) {
		String nextPage;
		if (bindingResult.hasErrors()) {
			nextPage = "index";
		}else {
			session.setAttribute("questionModel", questionModel);
			nextPage = "redirect:/question/1";
		}
		return nextPage;
	}
	
	@GetMapping("/question/{index}")
	public String toNextQuestion(Model model, @PathVariable("index") Integer index) {
		Questions question = questionService.getQuestion(index);
		model.addAttribute("question", question);
		model.addAttribute("index", index.intValue());
		
		return "question";
	}
	
	@PostMapping("/answer/{index}")
	public String answerHandle(Model model, @PathVariable("index") Integer index, HttpServletRequest request) {
		String answerValue = (String) request.getParameter("answer" + index.toString());
		
		String nextPage = "";
		QuestionModel questionModel = (QuestionModel) session.getAttribute("questionModel");
		switch (index.intValue()) {
			case 1:
				questionModel.setAnswer1(answerValue);
				break;
			case 2:
				questionModel.setAnswer2(answerValue);
				break;
			case 3:
				questionModel.setAnswer3(answerValue);
		}

		index++;

		if(index > 3) {
			List<QuestionResult> resultList = questionService.getResult(questionModel);
			model.addAttribute("resultList", resultList);
			model.addAttribute("name", questionModel.getName());
			model.addAttribute("questionCount", resultList.size());
			model.addAttribute("correctCount", questionService.getCorrectCount(resultList));
			nextPage ="result";
		}else {	
			nextPage = "redirect:/question/" + index;
		}

		session.setAttribute("questionModel", questionModel);
		
		return nextPage;
	}
	
    @ExceptionHandler(Exception.class)
    private String exceptionHandler(Model model, Exception e) {
        System.out.println(e.toString());
        model.addAttribute("message", e.toString());
        return "error";
    }
}
