package com.garrett.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.garrett.language.models.Language;
import com.garrett.language.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService langServ;
	
	public LanguagesController(LanguageService langServ) {
		this.langServ = langServ;
	}
	
	@GetMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language lang) {
		List<Language> languages = langServ.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id") Long id, Model model) {
		Language lang = langServ.findLang(id);
		model.addAttribute("language", lang);
		return "/languages/edit.jsp";
	}
	
	@GetMapping("/languages/{id}")
	public String showLang(@PathVariable("id") Long id, Model model) {
		Language lang = langServ.findLang(id);
		model.addAttribute("language", lang);
		return "/languages/show.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/index.jsp";
		} else {
			langServ.createLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/edit.jsp";
		} else {
			langServ.updateLang(lang);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable("id") Long id) {
		langServ.deleteLang(id);
		return "redirect:/languages";
	}
	
}
