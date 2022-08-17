package com.arrendaaki.utility;

import com.arrendaaki.model.Locality;

public class LocalityUtility {
	
	public static void alterIfNotNullOrEmpty(Locality locality, Locality alteredLocality) {
		if (alteredLocality.getDesignation() != null) {
			locality.setDesignation(alteredLocality.getDesignation());
		}
		
		if (alteredLocality.getPlaces() != null && !alteredLocality.getPlaces().isEmpty()) {
			locality.getPlaces().addAll(alteredLocality.getPlaces());
		}
	}
}
