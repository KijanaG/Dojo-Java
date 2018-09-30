package com.garrett.countries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garrett.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
