package com.arrendaaki.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Locality implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_locality")
	private long pkLocaity;
	
	@Column(nullable = false)
	private String designation;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(
		name = "fk_locality",
		foreignKey = @ForeignKey(name = "fk_locality_fkey")
	)
	private List<Locality> places;
	
	public Locality() {
	}
	
	public long getPkLocaity() {
		return pkLocaity;
	}
	public void setPkLocaity(long pkLocaity) {
		this.pkLocaity = pkLocaity;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<Locality> getPlaces() {
		return places;
	}

	public void setPlaces(List<Locality> places) {
		this.places = places;
	}
}
