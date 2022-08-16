package com.arrendaaki.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class House implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_house")
	private long pkHouse;
	
	@Column(name = "home_type", nullable = false)
	private String homeType;	//	vivenda, apartamento
	
	@OneToOne(optional = false)
	@JoinColumn(name = "fk_room_number")	//	T1, T2, .. Tn
	private RoomNumber roomNumber;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "fk_locality")
	private Locality locality;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "fk_person")
	private Person lessor;

	public long getPkHouse() {
		return pkHouse;
	}

	public void setPkHouse(long pkHouse) {
		this.pkHouse = pkHouse;
	}

	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	public RoomNumber getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(RoomNumber roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

	public Person getLessor() {
		return lessor;
	}

	public void setLessor(Person lessor) {
		this.lessor = lessor;
	}
	
}
