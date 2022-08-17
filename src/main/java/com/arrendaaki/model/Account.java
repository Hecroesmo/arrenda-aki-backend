package com.arrendaaki.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_account")
	private long pkAccount;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@OneToOne
	private AccountType accountType;

	public Account() {
		super();
	}

	public long getPkAccount() {
		return pkAccount;
	}

	public void setPkAccount(long pkAccount) {
		this.pkAccount = pkAccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
