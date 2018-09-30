package com.garrett.dojos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garrett.dojos.models.Ninja;
import com.garrett.dojos.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}

}
