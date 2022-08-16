package com.arrendaaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrendaaki.model.AccountType;
import com.arrendaaki.repository.AccountTypeRepository;

@Service
public class AccountTypeService {
	@Autowired
	private AccountTypeRepository accountTypeRepo;
	
	public Iterable<AccountType> findAll() {
		return accountTypeRepo.findAll();
	}
	
	public AccountType findById(long id) {
		return accountTypeRepo.findById(id).get();
	}
	
	public AccountType save(AccountType accountType) {
		return accountTypeRepo.save(accountType);
	}
	
	public void deleteById(long id) {
		accountTypeRepo.deleteById(id);
	}
}
