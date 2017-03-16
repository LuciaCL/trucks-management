package com.lucia.trucksmanagement.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucia.trucksmanagement.persistence.dao.Identifiable;

@Entity
@Table(name="customer")
public class Customer implements Identifiable<Long>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "cif")
	private String cif;
	
	@Column(name = "address")
	private Double address;

	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public Double getAddress() {
		return address;
	}
	public void setAddress(Double address) {
		this.address = address;
	}
	
	public void setId(Long id) {
		this.id = id;
		
	}
	
	public Long getId() {
		return id;
	}
}
