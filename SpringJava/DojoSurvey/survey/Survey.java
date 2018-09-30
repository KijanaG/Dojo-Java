package com.garrett.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Survey {
	@RequestMapping("/")
	public String survey() {
		return "survey.jsp";
	}
	@RequestMapping(value="/result", method = RequestMethod.POST)
	public String result(@RequestParam(value="name") String name, 
			@RequestParam(value="select") String location, 
			@RequestParam(value="language") String language, 
			@RequestParam(value="message") String message, Model model) {
		model.addAttribute("location", location);
		model.addAttribute("name", name);
		model.addAttribute("language", language);
		model.addAttribute("message", message);
		return "result.jsp";
	}
}
