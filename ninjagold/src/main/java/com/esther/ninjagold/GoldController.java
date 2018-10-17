package com.esther.ninjagold;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GoldController {
	
	@RequestMapping("/gold")
	public String gold(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		else {
			model.addAttribute("gold", session.getAttribute("gold"));
		}
		
		return "gold.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String processMoney(HttpSession session, @RequestParam(value="building") String building, RedirectAttributes redirectAttributes, Model model) {
		
		int v = 0;
		
		if (building.equals("farm")) {
			Random r = new Random();
			v = r.nextInt(11) + 10;
			int newGold = (Integer) session.getAttribute("gold") + v;
			System.out.println(newGold);
			session.setAttribute("gold", newGold);
			
		}
		
		if (building.equals("cave")) {
			Random r = new Random();
			v = r.nextInt(6) + 5;
			int newGold = (Integer) session.getAttribute("gold") + v;
			System.out.println(newGold);
			session.setAttribute("gold", newGold);
			
		}
		
		if (building.equals("house")) {
			Random r = new Random();
			v = r.nextInt(4) + 2;
			int newGold = (Integer) session.getAttribute("gold") + v;
			System.out.println(newGold);
			session.setAttribute("gold", newGold);
			
		}
		
		if (building.equals("casino")) {
			Random r = new Random();
			v = r.nextInt(101) - 50;
			int newGold = (Integer) session.getAttribute("gold") + v;
			System.out.println(newGold);
			session.setAttribute("gold", newGold);
			
		}
		
		Date date = new Date();
		if (v > 0) {
			redirectAttributes.addFlashAttribute("activities", "You won " + v + " gold!  " + date);
		}
		if (v < 0) {
			redirectAttributes.addFlashAttribute("activities", "You lost " + v + " gold!  " + date);
		}
		
		if ((Integer)session.getAttribute("gold") < 0) {
			session.setAttribute("gold", 0);
		}
		
	return "redirect:/gold";
	}

}
