package com.lucia.trucksmanagement.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucia.trucksmanagement.persistence.dao.Identifiable;



@Entity
@Table(name="journey")
public class Journey implements Identifiable<Long>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "origin")
	private String origin;
	@Column(name = "destination")
	private String destination;
	@Column(name = "princeKm")
	private Double priceKm;
	@Column(name = "customerId")
	private Long customerId;
	@Column(name = "description")
	private String description;

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getPriceKm() {
		return priceKm;
	}
	public void setPriceKm(Double priceKm) {
		this.priceKm = priceKm;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
