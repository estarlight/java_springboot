package com.esther.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esther.countries.services.ApiService;

@Controller
public class CountryController {
	
	private final ApiService service;
	
	public CountryController(ApiService service) {
		this.service = service;
	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Object[]> table = service.numberOne();
//		model.addAttribute("table", table);
//	return "index.jsp";
//	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Object[]> table = service.numberTwo();
//		model.addAttribute("table", table);
//	return "index.jsp";
//	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Object[]> table = service.numberThree("Mexico", 500000);
//		model.addAttribute("table", table);
//	return "index.jsp";
//	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Object[]> table = service.numberFour();
//		model.addAttribute("table", table);
//	return "index.jsp";
//	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Object[]> table = service.numberFive();
//		model.addAttribute("table", table);
//	return "index.jsp";
//	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Object[]> table = service.numberSix();
//		model.addAttribute("table", table);
//	return "index.jsp";
//	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Object[]> table = service.numberSeven();
//		model.addAttribute("table", table);
//	return "index.jsp";
//	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Object[]> table = service.numberEight();
		model.addAttribute("table", table);
	return "index.jsp";
	}
	

	
}