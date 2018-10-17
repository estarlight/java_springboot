package com.esther.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esther.relationships.models.Dojo;
import com.esther.relationships.models.Ninja;
import com.esther.relationships.services.DojoNinjaService;

@Controller
public class DojoNinjaController {
	
	private final DojoNinjaService dnService;
	
	public DojoNinjaController(DojoNinjaService dnService) {
		this.dnService = dnService;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
            return "/dojos/new.jsp";
        } else {
            dnService.newDojo(dojo);
            return "redirect:/dojos/new";
        } 
		
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dnService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
            return "/ninjas/new.jsp";
        } else {
            dnService.newNinja(ninja);
            return "redirect:/ninjas/new";
        } 
		
	}
	
	@RequestMapping("dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dnService.findDojo(id);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo", dojo);
		return "/dojos/show.jsp";
	}

}
