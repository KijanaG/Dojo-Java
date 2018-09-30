package com.garrett.relations.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garrett.relations.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

}
