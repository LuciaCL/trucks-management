package com.lucia.trucksmanagement.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucia.trucksmanagement.persistence.dao.Identifiable;



@Entity
@Table(name="section")
public class Section implements Identifiable<Long>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "initalLatitude")	
	private String initialLatitude;
	@Column(name = "finalLatitude")
	private String finalLatitude;
	@Column(name = "initialLongitude")
	private String initialLongitude;
	@Column(name = "finalLongitude")
	private String finalLongitude;
	@Column(name = "initialPoint")
	private String initialPoint;
	@Column(name = "initialDate")
	private String initialDate;
	@Column(name = "finalDate")
	private String finalDate;
	@Column(name = "carrierId")
	private Long carrierId;
	@Column(name = "journeyId")
	private Long journeyId;
	@Column(name = "trailerId")
	private Long trailerId;
	@Column(name = "truckId")
	private Long truckId;

	
	public String getInitialLatitude() {
		return initialLatitude;
	}
	public void setInitialLatitude(String initialLatitude) {
		this.initialLatitude = initialLatitude;
	}
	public String getFinalLatitude() {
		return finalLatitude;
	}
	public void setFinalLatitude(String finalLatitude) {
		this.finalLatitude = finalLatitude;
	}
	public String getInitialLongitude() {
		return initialLongitude;
	}
	public void setInitialLongitude(String initialLongitude) {
		this.initialLongitude = initialLongitude;
	}
	public String getFinalLongitude() {
		return finalLongitude;
	}
	public void setFinalLongitude(String finalLongitude) {
		this.finalLongitude = finalLongitude;
	}
	public String getInitialPoint() {
		return initialPoint;
	}
	public void setInitialPoint(String initialPoint) {
		this.initialPoint = initialPoint;
	}
	public String getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}
	public String getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}
	public Long getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}
	public Long getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(Long journeyId) {
		this.journeyId = journeyId;
	}
	public Long getTrailerId() {
		return trailerId;
	}
	public void setTrailerId(Long trailerId) {
		this.trailerId = trailerId;
	}
	public Long getTruckId() {
		return truckId;
	}
	public void setTruckId(Long truckId) {
		this.truckId = truckId;
	}

	public void setId(Long id) {
		this.id = id;
		
	}
	
	public Long getId() {
		return id;
	}
	
}
