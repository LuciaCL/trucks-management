package com.lucia.trucksmanagement.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucia.trucksmanagement.persistence.dao.Identifiable;



@Entity
@Table(name="cInterval")
public class CInterval implements Identifiable<Long> {
	//Intervals that need to do it the carrier.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "timeIni")
	private String timeIni;
	
	@Column(name = "timeFin")
	private String timeFin;
	
	@Column(name = "carrierId")
	private Long carrierId;


	public String getTimeIni() {
		return timeIni;
	}
	public void setTimeIni(String timeIni) {
		this.timeIni = timeIni;
	}
	public String getTimeFin() {
		return timeFin;
	}
	public void setTimeFin(String timeFin) {
		this.timeFin = timeFin;
	}
	public Long getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
}
