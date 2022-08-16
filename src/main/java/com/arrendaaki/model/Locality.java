package com.arrendaaki.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locality implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_locality")
	private long pkLocaity;
	
	@Column(nullable = false)
	private String designation;
	
	@Column(name = "fk_locality")
	private long fkLocality;
	
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
	public long getFkLocality() {
		return fkLocality;
	}
	public void setFkLocality(long fkLocality) {
		this.fkLocality = fkLocality;
	}
}
