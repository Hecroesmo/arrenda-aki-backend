package com.arrendaaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrendaaki.model.Person;
import com.arrendaaki.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepo;
	
	public Iterable<Person> findAll() {
		return personRepo.findAll();
	}
	
	public Person findById(long id) {
		return personRepo.findById(id).get();
	}
	
	public Person save(Person person) {
		return personRepo.save(person);
	}
	
	public void deleteById(long id) {
		personRepo.deleteById(id);
	}
}
