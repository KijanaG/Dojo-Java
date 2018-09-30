package com.garrett.relations.services;

import org.springframework.stereotype.Service;

import com.garrett.relations.models.License;
import com.garrett.relations.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
	
	public LicenseService(LicenseRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public License createLicense(License license) {
		String iden;
		License l = licenseRepo.save(license);
		String id = Long.toString(l.getId());
		if(id.length() == 1) {
			iden = "0000"+id;
		} else {
			iden = "000"+id;
		}
		l.setNumber(iden);
		return licenseRepo.save(l);
	}
	
}
