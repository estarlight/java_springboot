package com.esther.countries.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long> {
	 
	List<Language> findAll();
	
	Language findByLanguage(String languageName);

}
