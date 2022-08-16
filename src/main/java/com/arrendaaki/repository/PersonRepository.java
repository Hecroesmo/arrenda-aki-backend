package com.arrendaaki.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arrendaaki.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
