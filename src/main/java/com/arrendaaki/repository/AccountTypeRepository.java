package com.arrendaaki.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arrendaaki.model.AccountType;

@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType, Long> {

}
