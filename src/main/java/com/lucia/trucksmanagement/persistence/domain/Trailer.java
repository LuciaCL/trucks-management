package com.lucia.trucksmanagement.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucia.trucksmanagement.persistence.dao.Identifiable;


@Entity
@Table(name="trailer")
public class Trailer implements Identifiable<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "plateNumber")
	private String plateNumber;
	@Column(name = "tare")
	private Double tare;
	@Column(name = "weight")
	private Double weight;
	@Column(name = "dimension")
	private Double dimension;
	@Column(name = "brand")
	private String brand;
	@Column(name = "model")
	private String model;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public Double getTare() {
		return tare;
	}
	public void setTare(Double tare) {
		this.tare = tare;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getDimension() {
		return dimension;
	}
	public void setDimension(Double dimension) {
		this.dimension = dimension;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
