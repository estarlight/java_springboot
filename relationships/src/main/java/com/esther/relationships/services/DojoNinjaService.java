package com.esther.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esther.relationships.models.Dojo;
import com.esther.relationships.models.Ninja;
import com.esther.relationships.repositories.DojoRepository;
import com.esther.relationships.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Dojo newDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public Ninja newNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if (dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if (ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}

}
