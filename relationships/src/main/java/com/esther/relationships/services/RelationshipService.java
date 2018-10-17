package com.esther.relationships.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esther.relationships.models.License;
import com.esther.relationships.models.Person;
import com.esther.relationships.repositories.LicenseRepo;
import com.esther.relationships.repositories.PersonRepo;

@Service
public class RelationshipService {
	
	private final LicenseRepo lR;
	private final PersonRepo pR;
	
	public RelationshipService(LicenseRepo lR, PersonRepo pR) {
		this.lR = lR;
		this.pR = pR;
	}
	
	public List<Person> getAllPersons(){
		return pR.findAll();
	}
	
	public Person createPerson(Person person) {
		return pR.save(person);
	}
	
	public License createLicense(License license) {
		return lR.save(license);
	}
	
	public License createLicense(Date date, String state, Person person) {
		License license = new License(date, state, person);
		return lR.save(license);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> person = pR.findById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}

}
