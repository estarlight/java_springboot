package com.esther.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.esther.countries.models.Language;
import com.esther.countries.repositories.CityRepository;
import com.esther.countries.repositories.CountryRepository;
import com.esther.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	
	private CountryRepository countryRepo;
	private LanguageRepository langRepo;
	private CityRepository cityRepo;
	
	public ApiService(CountryRepository countryRepo, LanguageRepository langRepo, CityRepository cRepo) {
		this.countryRepo = countryRepo;
		this.langRepo = langRepo;
		this.cityRepo = cityRepo;
	}
	
	public List<Object[]> numberOne() {

		List<Object[]> table = countryRepo.countryByLanguage("Slovene");
		for (Object[] row : table) {
			String countryName = (String) row[0];
			String languageName = (String) row[1];
			Double percentage = (Double) row [2];
			System.out.print("Country: " + countryName + " Language: " + languageName + " Percentage: " + percentage);
		}
		
		return table;
		
	}
	
	public List<Object[]> numberTwo() {
		List<Object[]> table = countryRepo.countryAndCityList();
		for(Object[] row : table) {
		System.out.println(row[1]);
		}
		return table;
	}
	
	public List<Object[]> numberThree(String country, int population) {
		List<Object[]> table = countryRepo.citiesInMexico(country, population);
		return table;
	}
	
	public List<Object[]> numberFour() {
		List<Object[]> table = countryRepo.languagePercentage();
		return table;
	}
	
	public List<Object[]> numberFive() {
		List<Object[]> table = countryRepo.surfaceArea();
		return table;
	}

	
	public List<Object[]> numberSix() {
		List<Object[]> table = countryRepo.constitutionalMonarchy();
		return table;
	}
	
	public List<Object[]> numberSeven() {
		List<Object[]> table = countryRepo.argentina();
		return table;
	}
	
	public List<Object[]> numberEight() {
		List<Object[]> table = countryRepo.summarize();
		return table;
	}
	
}
