package com.arrendaaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrendaaki.model.Account;
import com.arrendaaki.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepo;
	
	public Iterable<Account> findAll() {
		return accountRepo.findAll();
	}
	
	public Account findById(long id) {
		return accountRepo.findById(id).get();
	}
	
	public Account save(Account account) {
		return accountRepo.save(account);
	}
	
	public void deleteById(long id) {
		accountRepo.deleteById(id);
	}
}
