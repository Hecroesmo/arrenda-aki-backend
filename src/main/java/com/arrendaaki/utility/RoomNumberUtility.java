package com.arrendaaki.utility;

import com.arrendaaki.model.RoomNumber;

public class RoomNumberUtility {
	public static void alterIfNotNullOrEmpty(RoomNumber roomNumber, RoomNumber alteredRoomNumber) {
		
		if (alteredRoomNumber.getDescription() != null) {
			roomNumber.setDescription(alteredRoomNumber.getDescription());
		}
	}
}
