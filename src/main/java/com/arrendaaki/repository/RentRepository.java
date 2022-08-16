package com.arrendaaki.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arrendaaki.model.Rent;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {

}
