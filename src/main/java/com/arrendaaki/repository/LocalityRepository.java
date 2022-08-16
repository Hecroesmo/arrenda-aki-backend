package com.arrendaaki.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arrendaaki.model.Locality;

@Repository
public interface LocalityRepository extends CrudRepository<Locality, Long> {

}
