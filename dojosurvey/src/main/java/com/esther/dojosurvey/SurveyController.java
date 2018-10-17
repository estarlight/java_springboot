package com.esther.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String request(HttpSession session, Model model, @RequestParam(value="name") String name, @RequestParam(value="language") String language, @RequestParam(value="location") String location, @RequestParam(value="comment") String comment) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
//		
//		model.addAttribute("name", name);
//		model.addAttribute("location", location);
//		model.addAttribute("language", language);
//		model.addAttribute("comment", comment);
		
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String results(HttpSession session, Model model) {
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("location", session.getAttribute("location"));
		model.addAttribute("language", session.getAttribute("language"));
		model.addAttribute("comment", session.getAttribute("comment"));
		
		return "result.jsp";
	}

}
		



