package com.arrendaaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrendaaki.model.Rent;
import com.arrendaaki.repository.RentRepository;

@Service
public class RentService {
	@Autowired
	private RentRepository rentRepo;
	
	public Iterable<Rent> findAll() {
		return rentRepo.findAll();
	}
	
	public Rent findById(long id) {
		return rentRepo.findById(id).get();
	}
	
	public Rent save(Rent rent) {
		return rentRepo.save(rent);
	}
	
	public void deleteById(long id) {
		rentRepo.deleteById(id);
	}
}
