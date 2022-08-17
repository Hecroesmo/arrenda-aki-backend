package com.arrendaaki.utility;

import com.arrendaaki.model.Account;

public class AccountUtility {
	public static void alterIfNotNullOrEmpty(Account account, Account alteredAccount) {
		if (alteredAccount.getUsername() != null) {
			account.setUsername(alteredAccount.getUsername());
		}
		
		if (alteredAccount.getPassword() != null) {
			account.setPassword(alteredAccount.getPassword());
		}
		
		AccountTypeUtility.alterIfNotNullOrEmpty(account.getAccountType(), alteredAccount.getAccountType());
		
	}
}
