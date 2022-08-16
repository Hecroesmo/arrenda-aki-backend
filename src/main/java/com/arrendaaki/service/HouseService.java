package com.arrendaaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrendaaki.model.House;
import com.arrendaaki.repository.HouseRepository;

@Service
public class HouseService {
	@Autowired
	private HouseRepository houseRepos;
	
	public Iterable<House> findAll() {
		return houseRepos.findAll();
	}
	
	public House findById(long id) {
		return houseRepos.findById(id).get();
	}
	
	public House save(House person) {
		return houseRepos.save(person);
	}
	
	public void deleteById(long id) {
		houseRepos.deleteById(id);
	}
}
