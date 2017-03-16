package com.lucia.trucksmanagement.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucia.trucksmanagement.persistence.dao.Identifiable;


@Entity
@Table(name="expense")
public class Expense implements Identifiable<Long>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "cost")
	private Double cost;
	@Column(name = "concept1")
	private String concept1;
	@Column(name = "concept2")
	private String concept2;
	@Column(name = "expenseDate")
	private String expenseDate;
	@Column(name = "carrierId")
	private Long carrierId;
	@Column(name = "journeyId")
	private Long journeyId;
	@Column(name = "trailerId")
	private Long trailerId;
	@Column(name = "truckId")
	private Long truckId;

	public Expense() {
		
	}
	
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getConcept1() {
		return concept1;
	}
	public void setConcept1(String concept1) {
		this.concept1 = concept1;
	}
	public String getConcept2() {
		return concept2;
	}
	public void setConcept2(String concept2) {
		this.concept2 = concept2;
	}
	public String getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
