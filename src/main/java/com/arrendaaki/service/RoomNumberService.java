package com.arrendaaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrendaaki.model.RoomNumber;
import com.arrendaaki.repository.RoomNumberRepository;

@Service
public class RoomNumberService {
	@Autowired
	private RoomNumberRepository roomNumberRepo;
	
	public Iterable<RoomNumber> findAll() {
		return roomNumberRepo.findAll();
	}
	
	public RoomNumber findById(long id) {
		return roomNumberRepo.findById(id).get();
	}
	
	public RoomNumber save(RoomNumber roomNumber) {
		return roomNumberRepo.save(roomNumber);
	}
	
	public void deleteById(long id) {
		roomNumberRepo.deleteById(id);
	}
}
