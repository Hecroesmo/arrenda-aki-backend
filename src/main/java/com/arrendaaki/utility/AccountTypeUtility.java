package com.arrendaaki.utility;

import com.arrendaaki.model.AccountType;

public class AccountTypeUtility {
	
	public static void alterIfNotNullOrEmpty(AccountType accountType, AccountType alteredAccountType) {
		if (alteredAccountType.getDesignation() != null) {
			accountType.setDesignation(alteredAccountType.getDesignation());
		}
	}

}
