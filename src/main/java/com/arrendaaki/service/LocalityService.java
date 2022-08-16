package com.arrendaaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrendaaki.model.Locality;
import com.arrendaaki.repository.LocalityRepository;

@Service
public class LocalityService {
	
	@Autowired
	private LocalityRepository localityRepo;
	
	public Iterable<Locality> findAll() {
		return localityRepo.findAll();
	}
	
	public Locality findById(long id) {
		return localityRepo.findById(id).get();
	}
	
	public Locality save(Locality locality) {
		return localityRepo.save(locality);
	}
	
	public void deleteById(long id) {
		localityRepo.deleteById(id);
	}

}
