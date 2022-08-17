package com.arrendaaki.utility;

import com.arrendaaki.model.Person;

public class PersonUtility {
	public static void alterIfNotNullOrEmpty(Person person, Person alteredPerson) {
		
		if (alteredPerson.getFirstName() != null) {
			person.setFirstName(alteredPerson.getFirstName());
		}
		
		if (alteredPerson.getLastName() != null) {
			person.setLastName(alteredPerson.getLastName());
		}
		
		if (alteredPerson.getEmail() != null) {
			person.setEmail(alteredPerson.getEmail());
		}
		
		if (alteredPerson.getBirthDate() != null) {
			person.setBirthDate(alteredPerson.getBirthDate());
		}
		
		if (alteredPerson.getPhoneNumber() != null) {
			person.setPhoneNumber(alteredPerson.getPhoneNumber());
		}
		
		AccountUtility.alterIfNotNullOrEmpty(person.getAccount(), alteredPerson.getAccount());
		
		LocalityUtility.alterIfNotNullOrEmpty(person.getLocality(), alteredPerson.getLocality());
	}
}
