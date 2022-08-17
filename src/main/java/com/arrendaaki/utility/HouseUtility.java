package com.arrendaaki.utility;

import com.arrendaaki.model.House;

public class HouseUtility {
	public static void alterIfNotNullOrEmpty(House house, House alteredHouse ) {
		if (alteredHouse.getHomeType() != null) {
			house.setHomeType(alteredHouse.getHomeType());
		}
		
		RoomNumberUtility.alterIfNotNullOrEmpty(house.getRoomNumber(), alteredHouse.getRoomNumber());
		LocalityUtility.alterIfNotNullOrEmpty(house.getLocality(), alteredHouse.getLocality());
		PersonUtility.alterIfNotNullOrEmpty(house.getLessor(), alteredHouse.getLessor());
	}
}
