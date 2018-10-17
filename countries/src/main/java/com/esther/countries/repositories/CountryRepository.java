package com.esther.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.countries.models.Country;
import com.esther.countries.models.Language;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {
	
	List<Country> findAll();
	
//	@Query("SELECT c, l FROM Country c JOIN c.languages l")
//	List<Object[]> joinCountriesAndLanugages();
//	
//	@Query("SELECT c, ct FROM Country c JOIN c.cities ct")
//	List<Object[]> joinCountriesAndCities();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = ?1 ORDER BY l.percentage desc")
	List<Object[]> countryByLanguage(String language);
	
	@Query("SELECT c.name, count(ct.id) FROM Country c JOIN c.cities ct GROUP BY c ORDER BY count(ct.id) desc")
	List<Object[]> countryAndCityList();
	
	@Query("SELECT ct.name, ct.population FROM Country c JOIN c.cities ct WHERE c.name = ?1 AND ct.population > ?2 ORDER BY ct.population desc")
	List<Object[]> citiesInMexico(String country, int population);
	
	@Query("SELECT l.language, c.name, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89.0 ORDER BY l.percentage desc")
	List<Object[]> languagePercentage();
	
	@Query("SELECT c.name, c.surfaceArea, c.population FROM Country c WHERE c.surfaceArea < 501 AND c.population > 100000")
	List<Object[]> surfaceArea();
	
	@Query("SELECT c.name, c.governmentForm, c.surfaceArea, c.lifeExpectancy FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.surfaceArea > 200.0 AND c.lifeExpectancy > 75.0")
	List<Object[]> constitutionalMonarchy();
	
	@Query("SELECT c.name, ct.name, ct.district, ct.population FROM Country c JOIN c.cities ct WHERE c.name = 'Argentina' AND ct.district='Buenos Aires' AND ct.population > 500000")
	List<Object[]> argentina();
	
	@Query("SELECT c.region, count(c.id) FROM Country c GROUP BY c.region ORDER BY count(c.id) desc")
	List<Object[]> summarize();
	

}
