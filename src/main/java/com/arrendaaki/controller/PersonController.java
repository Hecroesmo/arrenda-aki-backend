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

import com.arrendaaki.model.Person;
import com.arrendaaki.service.PersonService;
import com.arrendaaki.utility.PersonUtility;

@RestController
@RequestMapping("/people")
@CrossOrigin
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Person> findAll() {
		return personService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Person findById(@PathVariable long id) {
		return personService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person save(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Person alter(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Person alter(@PathVariable long id, @RequestBody Person alteredPerson) {
		
		Person person = personService.findById(id);
		PersonUtility.alterIfNotNullOrEmpty(person, alteredPerson);
		return personService.save(person);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		try 
		{
			personService.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			
		}
	}
}
