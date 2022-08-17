package com.arrendaaki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arrendaaki.model.House;
import com.arrendaaki.service.HouseService;
import com.arrendaaki.utility.HouseUtility;

@RestController
@RequestMapping("/houses")
@CrossOrigin
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<House> findAll() {
		return houseService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public House findById(@PathVariable long id) {
		return houseService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public House save(@RequestBody House house) {
		return houseService.save(house);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public House alter(@RequestBody House house) {
		return houseService.save(house);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public House alter(@PathVariable long id, @RequestBody House alteredHouse) {
		
		House house = houseService.findById(id);
		HouseUtility.alterIfNotNullOrEmpty(house, alteredHouse);
		return houseService.save(house);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		try 
		{
			houseService.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			
		}
	}
}
