package com.esther.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CounterContoller {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		if (session.getAttribute("count")== null) {
			session.setAttribute("count", 1);
		}
		else {
			int count = (Integer) session.getAttribute("count") + 1;
			session.setAttribute("count", count);
			
		}
				
		return "index.jsp";
		
	}
	
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		
		model.addAttribute("count", session.getAttribute("count"));
		
		return "counter.jsp";
	}
	
	@RequestMapping(value="/clear", method=RequestMethod.POST)
	public String clear(HttpSession session, Model model) {
		session.removeAttribute("count");
	
		
		return "redirect:/counter";
	}

}
