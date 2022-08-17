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

import com.arrendaaki.model.AccountType;
import com.arrendaaki.service.AccountTypeService;
import com.arrendaaki.utility.AccountTypeUtility;

@RestController
@RequestMapping("/types-of-accounts")
@CrossOrigin
public class AccountTypeController {
	@Autowired
	private AccountTypeService accountTypeService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<AccountType> findAll() {
		return accountTypeService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccountType findById(@PathVariable long id) {
		return accountTypeService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AccountType save(@RequestBody AccountType accountType) {
		return accountTypeService.save(accountType);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public AccountType alter(@RequestBody AccountType accountType) {
		return accountTypeService.save(accountType);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccountType alter(@PathVariable long id, @RequestBody AccountType alteredAccountType) {
		AccountType accountType = accountTypeService.findById(id);
		AccountTypeUtility.alterIfNotNullOrEmpty(accountType, alteredAccountType);		
		return accountTypeService.save(accountType);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		try {
			accountTypeService.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			
		}
	}
}
