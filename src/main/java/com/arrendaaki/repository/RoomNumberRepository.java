package com.arrendaaki.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arrendaaki.model.RoomNumber;

@Repository
public interface RoomNumberRepository extends CrudRepository<RoomNumber, Long> {

}
