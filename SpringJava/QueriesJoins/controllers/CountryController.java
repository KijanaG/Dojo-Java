package com.garrett.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.garrett.countries.services.APIServices;

@Controller
public class CountryController {
	private final APIServices apiService;
	
	public CountryController(APIServices apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String queriesJoins(Model model) {
//		List<Object[]> tables = apiService.sloveneCountries(); (1)
//		List<Object[]> tables = apiService.totalCities(); (2)
//		List<Object[]> tables = apiService.mexico(); (3)
//		List<Object[]> tables = apiService.high(); (4)
//		List<Object[]> tables = apiService.surfacePop(); (5)
//		List<Object[]> tables = apiService.govv(); (6)
//		model.addAttribute("table", tables);
		return "/countries/new.jsp";
	}

}
