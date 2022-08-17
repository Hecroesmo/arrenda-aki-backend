package com.arrendaaki.utility;

import com.arrendaaki.model.Rent;

public class RentUtility {
	public static void alterIfNotNullOrEmpty(Rent rent, Rent alteredRent) {
		if (alteredRent.getDepartureDate() != null) {
			rent.setDepartureDate(alteredRent.getDepartureDate());
		}
		
		if (alteredRent.getLeaseDate() != null) {
			rent.setLeaseDate(alteredRent.getLeaseDate());
		}
		
		HouseUtility.alterIfNotNullOrEmpty(rent.getHouse(), alteredRent.getHouse());
		PersonUtility.alterIfNotNullOrEmpty(rent.getTenant(), alteredRent.getTenant());
		
	}
}
