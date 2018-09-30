package com.garrett.relations.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garrett.relations.models.Person;
import com.garrett.relations.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepo;
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	public List<Person> allPersons() {
		return personRepo.findAll();
	}
	
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}

	public Person showPerson(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}

}
