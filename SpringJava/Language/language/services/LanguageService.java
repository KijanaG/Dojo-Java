package com.garrett.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.garrett.language.models.Language;
import com.garrett.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	 
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language l) {
		return langRepo.save(l);
	}
	
	public Language findLang(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public void deleteLang(Long id) {
		langRepo.deleteById(id);
	}
	
	public void updateLang(Language l) {
		langRepo.save(l);
	}

}
