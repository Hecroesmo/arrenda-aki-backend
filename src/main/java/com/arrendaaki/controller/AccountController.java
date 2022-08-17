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

import com.arrendaaki.model.Account;
import com.arrendaaki.service.AccountService;
import com.arrendaaki.utility.AccountUtility;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Account> findAll() {
		return accountService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Account findById(@PathVariable long id) {
		return accountService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Account save(@RequestBody Account account) {
		return accountService.save(account);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Account alter(@RequestBody Account account) {
		return accountService.save(account);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Account alter(@PathVariable long id, @RequestBody Account alteredAccount) {
		Account account = accountService.findById(id);
		AccountUtility.alterIfNotNullOrEmpty(account, alteredAccount);		
		return accountService.save(account);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		try 
		{
			accountService.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			
		}
	}
}
