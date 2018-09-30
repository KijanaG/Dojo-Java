package com.garrett.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garrett.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
//	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
//	List<Object[]> findSloveneCountries();
//
//	@Query("SELECT c.name, COUNT(cit) FROM Country c JOIN c.cities cit GROUP BY c.name ORDER BY COUNT(cit) DESC")
//	List<Object[]> displayCityCount();
	
//	@Query("SELECT cit.name, cit.population FROM Country c JOIN c.cities cit WHERE c.name ='MEXICO' AND cit.population > 50000 ORDER BY cit.population DESC")
//	List<Object[]> largeMexicanCities();
//	
//	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
//	List<Object[]> highPercent();
	
//	@Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < 501 AND c.population > 100000")
//	List<Object[]> surfacePOP();
	
//	@Query("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form ='Constitutional Monarchy' AND c.surface_area > 200 AND c.life_expectancy > 75")
//	List<Object[]> govType();
	
//	@Query("SELECT c.name, cit.name, cit.district, cit.population FROM Country c ")
//	List<Object[]> citiesInArgentina();
}
