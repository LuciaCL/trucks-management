package com.lucia.trucksmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucia.trucksmanagement.persistence.dao.HibernateDaoImpl;
import com.lucia.trucksmanagement.persistence.domain.Trailer;

@Service
public class TrailerService {

	@Resource(name="trailerDao")
	private HibernateDaoImpl<Trailer, Long> trailerDao;
	
	@Transactional
	public void createTrailer(Trailer trailer) {
		trailerDao.persist(trailer);
	}
	
	@Transactional
	public void updateTrailer(Trailer trailer) {
		trailerDao.merge(trailer);
	}
	
	@Transactional
	public Trailer find(Long trailerId) {
		return trailerDao.find(trailerId);
	}
	
	@Transactional
	public Trailer findByPlateNumber(String plateNumber) {
		return trailerDao.findByUniqueField("plateNumber", plateNumber);
	}
	
	@Transactional
	public List<Trailer> findAll() {
		List<Trailer> trailers = new ArrayList<Trailer>(trailerDao.findAll());
		return trailers;
	}
}
