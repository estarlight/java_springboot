package com.esther.relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.esther.relationships.models.License;
import com.esther.relationships.models.Person;
import com.esther.relationships.services.RelationshipService;

@Controller
public class RelationshipController {
	
	private final RelationshipService relService;
	
	public RelationshipController(RelationshipService relService) {
		this.relService = relService;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {	
		return "/persons/new.jsp";
		
	}
	
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
            return "/persons/new.jsp";
        } else {
            relService.createPerson(person);
            return "redirect:/persons/new";
        } 
	}
		
		@RequestMapping("/licenses/new")
		public String newLicense(@ModelAttribute("license") License license, Model model) {	
			List<Person> persons = relService.getAllPersons();
			model.addAttribute("personList", persons);
			return "/license/new.jsp";
			
		}
		
//		@PostMapping("/licenses/new")
//		public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
//			if (result.hasErrors()) {
//	            return "/license/new.jsp";
//	        } else {
//	            relService.createLicense(license);
//	            return "redirect:/licenses/new";
//	        } 
//		
//	}
		
		@PostMapping("/licenses/new")
		public String createLicense(@RequestParam(value="person") Person person, @RequestParam(value="expiration_date") String date, @RequestParam(value="state") String state) throws ParseException {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-d");
			Date newDate = formatter.parse(date);
			License newLicense = relService.createLicense(newDate, state, person);
			
			Person p = newLicense.getPerson();
			Long pId = p.getId();
		
			String number = String.format("%06d", pId);
			newLicense.setNumber(number);
		
			
			return "redirect:/licenses/new";
		}
		
		@RequestMapping("/persons/{id}")
		public String profile(@PathVariable("id") Long id, Model model) {
			Person person = relService.findPerson(id);
			model.addAttribute("person", person);
			return "/persons/profile.jsp";
			
		}
	
	

}
