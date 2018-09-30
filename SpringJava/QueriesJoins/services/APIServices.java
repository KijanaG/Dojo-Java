package com.garrett.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garrett.countries.models.Country;
import com.garrett.countries.repositories.CityRepository;
import com.garrett.countries.repositories.CountryRepository;
import com.garrett.countries.repositories.LanguageRepository;

@Service
public class APIServices {
	private final CityRepository cityRepo;
	private final CountryRepository countryRepo;
	private final LanguageRepository languageRepo;
	
	public APIServices(CityRepository cityRepo, CountryRepository countryRepo, LanguageRepository languageRepo) {
		this.cityRepo = cityRepo;
		this.countryRepo = countryRepo;
		this.languageRepo = languageRepo;
	}
	
//	public List<Object[]> sloveneCountries() {
//		return countryRepo.findSloveneCountries();
//	}
	
//	public List<Object[]> totalCities() {
//		return countryRepo.displayCityCount();
//	}
	
//	public List<Object[]> mexico() {
//		return countryRepo.largeMexicanCities();
//	}
	
//	public List<Object[]> high() {
//		return countryRepo.highPercent();
//	}
	
//	public List<Object[]> surfacePop() {
//		return countryRepo.surfacePOP();
//	}
	
//	public List<Object[]> govv() {
//		return countryRepo.govType();
//	}

}
