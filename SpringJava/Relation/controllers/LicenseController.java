package com.garrett.relations.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.garrett.relations.models.License;
import com.garrett.relations.models.Person;
import com.garrett.relations.services.LicenseService;
import com.garrett.relations.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseServe;
	private final PersonService personServe;
	public LicenseController(LicenseService licenseServe, PersonService personServe) {
		this.personServe = personServe;
		this.licenseServe = licenseServe;
	}
	
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/license/new.jsp";
	}
	
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/license/new.jsp";
		} else {
			personServe.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@GetMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person p = personServe.showPerson(id);
		System.out.println("THIS PERSON "+p.getFirstName());
		model.addAttribute("first", p.getFirstName());
		model.addAttribute("last", p.getLastName());
		model.addAttribute("license", p.getLicense().getNumber());
		model.addAttribute("state", p.getLicense().getState());
		model.addAttribute("exp", p.getLicense().getExpiration_date());
		return "/license/person.jsp";
	}
	
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> p = personServe.allPersons();
		model.addAttribute("persons", p);
		return "/license/license.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result){
		if(result.hasErrors()) {
			return "redirect:/licenses/new";
		} else {
		License l = licenseServe.createLicense(license);
		Long id = l.getPerson().getId();
		return "redirect:/persons/"+id;
	}
	}

}
