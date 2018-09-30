package com.garrett.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.garrett.dojos.models.Dojo;
import com.garrett.dojos.models.Ninja;
import com.garrett.dojos.services.DojoService;
import com.garrett.dojos.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoServe;
	private final NinjaService ninjaServe;
	public DojoController(DojoService dojoServe, NinjaService ninjaServe) {
		this.dojoServe = dojoServe;
		this.ninjaServe = ninjaServe;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/dojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/dojos/new";
		} else {
			dojoServe.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoServe.getAll();
		model.addAttribute("dojos", dojos);
		return "/dojos/ninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(ninja+"   :   "+result);
			return "redirect:/ninjas/new";
		} else {
			System.out.println("WE OUTCHEE");
			Ninja n = ninjaServe.createNinja(ninja);
			Long id = n.getDojo().getId();
			return "redirect:/dojos/"+id;
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServe.findDojo(id);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("name", dojo.getName());
		model.addAttribute("ninjas", ninjas);
		return "/dojos/profile.jsp";
	}
	
}
