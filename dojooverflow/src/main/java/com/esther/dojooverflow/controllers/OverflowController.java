package com.esther.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.esther.dojooverflow.models.Answer;
import com.esther.dojooverflow.models.Question;
import com.esther.dojooverflow.models.Tag;
import com.esther.dojooverflow.services.OverflowService;

@Controller
public class OverflowController {
	
	private final OverflowService oService;
	
	public OverflowController(OverflowService oService) {
		this.oService = oService;
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = oService.allQuestions();
		model.addAttribute("questions", questions);
		return "/questions/index.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("questions") Question question) {
		
		return "/questions/new.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(@RequestParam(value="question") String q, @RequestParam(value="tags") String tags, RedirectAttributes redirectAttributes) {
		System.out.println("Came here");
		
		ArrayList<String> tagsToAdd = new ArrayList<String>();
		
		for (String str : tags.split(", ")) {
			tagsToAdd.add(str);
		}
		
		if (tagsToAdd.size()>3) {
			redirectAttributes.addFlashAttribute("error", "You cannot add more than 3 tags");
			return "redirect:/questions/new";
		}
		
		Question finalQuestion = oService.saveQuestion(q);
		
		for (String tag : tagsToAdd) {
		Tag checkTag = oService.findTagBySubject(tag);
			if (checkTag != null) {
				System.out.println("This tag " + checkTag + " already exists");
				oService.addExistingTag(checkTag, finalQuestion);
			}
			else {
				oService.addTags(finalQuestion, tag);
			}
		}	
		
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions/{id}")
	public String profile(@PathVariable("id") Long id, Model model, @ModelAttribute("answers") Answer answer) {
		Question question = oService.findQuestion(id);
		
		model.addAttribute("question", question);
		return "/questions/profile.jsp";
	}
	
	@PostMapping("/questions/{id}")
	public String addAnswer(@PathVariable("id") Long id, @Valid @ModelAttribute("answers") Answer answer, BindingResult result, @RequestParam("answer") String a) {
		if (result.hasErrors()) {
			return "/questions/profile.jsp";
		} else {
			Question question = oService.findQuestion(id);
			List<Answer> answerList = question.getAnswers();
			
			Answer newAnswer = oService.addAnswer(a);
			System.out.println(answerList);
			newAnswer.setQuestion(question);
			answerList.add(newAnswer);
			question.setAnswers(answerList);
			oService.addQuestion(question);
			return "redirect:/questions/{id}";
		}
	}
	
	
	
	
}


