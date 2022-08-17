package com.arrendaaki.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_rent")
	private long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(
		name = "fk_house",
		foreignKey = @ForeignKey(name = "fk_house_fkey")
	)
	private House house;
	
	@ManyToOne(optional = false)
	@JoinColumn(
		name = "fk_person",
		foreignKey = @ForeignKey(name = "fk_person_fkey")
	)
	private Person tenant;	//	Inquilino
	
	@Column(name = "lease_date")
	private String leaseDate;	//	data de arrendamento
	
	@Column(name = "departure_date")
	private String departureDate;	// data do término da renda

	public Rent() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Person getTenant() {
		return tenant;
	}

	public void setTenant(Person tenant) {
		this.tenant = tenant;
	}

	public String getLeaseDate() {
		return leaseDate;
	}

	public void setLeaseDate(String leaseDate) {
		this.leaseDate = leaseDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
}
