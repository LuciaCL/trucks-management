package com.lucia.trucksmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucia.trucksmanagement.persistence.dao.HibernateDaoImpl;
import com.lucia.trucksmanagement.persistence.domain.Journey;

@Service
public class JourneyService {

	@Resource(name="journeyDao")
	private HibernateDaoImpl<Journey, Long> journeyDao;
	
	@Transactional
	public void createJourney(Journey journey) {
		journeyDao.persist(journey);
	}
	
	@Transactional
	public void updateJourney(Journey journey) {
		journeyDao.merge(journey);
	}
	
	@Transactional
	public Journey find(Long journeyId) {
		return journeyDao.find(journeyId);
	}
	
	@Transactional
	public Journey findByOrigin(String origin) {
		return journeyDao.findByUniqueField("origin", origin);
	}
	@Transactional
	public List<Journey> findAll() {
		List<Journey> journeys = new ArrayList<Journey>(journeyDao.findAll());
		return journeys;
	}
	
}
