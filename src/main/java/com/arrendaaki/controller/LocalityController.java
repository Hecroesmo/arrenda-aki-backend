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

import com.arrendaaki.model.Locality;
import com.arrendaaki.service.LocalityService;
import com.arrendaaki.utility.LocalityUtility;

@RestController
@RequestMapping("/places")
@CrossOrigin
public class LocalityController {
	@Autowired
	private LocalityService localityService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Locality> findAll() {
		return localityService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Locality findById(@PathVariable long id) {
		return localityService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Locality save(@RequestBody Locality locality) {
		return localityService.save(locality);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Locality alter(@RequestBody Locality locality) {
		return localityService.save(locality);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Locality alter(@PathVariable long id, @RequestBody Locality alteredLocality) {
		Locality locality = localityService.findById(id);
		LocalityUtility.alterIfNotNullOrEmpty(locality, alteredLocality);		
		return localityService.save(locality);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		try 
		{
			localityService.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			
		}
	}
}
