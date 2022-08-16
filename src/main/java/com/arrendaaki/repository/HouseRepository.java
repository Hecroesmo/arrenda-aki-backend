package com.arrendaaki.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arrendaaki.model.House;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

}
