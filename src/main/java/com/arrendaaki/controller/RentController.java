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

import com.arrendaaki.model.Rent;
import com.arrendaaki.service.RentService;
import com.arrendaaki.utility.RentUtility;

@RestController
@RequestMapping("/rents")
@CrossOrigin
public class RentController {
	
	@Autowired
	private RentService rentService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Rent> findAll() {
		return rentService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Rent findById(@PathVariable long id) {
		return rentService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Rent save(@RequestBody Rent rent) {
		return rentService.save(rent);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Rent alter(@RequestBody Rent rent) {
		return rentService.save(rent);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Rent alter(@PathVariable long id, @RequestBody Rent alteredRent) {
		
		Rent rent = rentService.findById(id);
		RentUtility.alterIfNotNullOrEmpty(rent, alteredRent);
		return rentService.save(rent);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		try 
		{
			rentService.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			
		}
	}
}
