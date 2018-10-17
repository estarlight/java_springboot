package com.esther.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esther.languages.models.Language;
import com.esther.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService (LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLangs(){
		return langRepo.findAll();
	}
	
	public Language createLang(Language language) {
		return langRepo.save(language);
	}
	
	public Language findLang(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if (optionalLang.isPresent()) {
			return optionalLang.get();
		}
		else {
			return null;
		}
	}
	
	public Language updateLang(Language lang) {
		langRepo.save(lang);
		return lang;
	}
	
	public void deleteLang(Long id) {
		langRepo.deleteById(id);
	}
	

}
