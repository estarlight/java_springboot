package com.esther.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esther.languages.models.Language;
import com.esther.languages.services.LanguageService;

@Controller
public class LanguagesController {
	
	private final LanguageService langService;
	
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/languages")
	public String index(@Valid @ModelAttribute("language") Language lang, Model model) {
		List<Language> languages = langService.allLangs();
		model.addAttribute("languages", languages);
		return "/languages/languages.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String createNew(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if (result.hasErrors()) {
            return "/languages/languages.jsp";
        } else {
            langService.createLang(lang);
            return "redirect:/languages";
        }  
		
	}
	
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("language", lang);
		return "/languages/show.jsp";
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("language", lang);
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/edit.jsp";
		}
		else {
			langService.updateLang(lang);
			return "redirect:/languages/{id}";
		}
	}
	
	@RequestMapping("/languages/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		langService.deleteLang(id);
		return "redirect:/languages";
	}
	

}
