package com.esther.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esther.relationships.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {
	
	List<License> findAll();
	
	

}
