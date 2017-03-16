package com.lucia.trucksmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucia.trucksmanagement.persistence.dao.HibernateDaoImpl;
import com.lucia.trucksmanagement.persistence.domain.CInterval;

@Service
public class CIntervalService {

	@Resource(name="cIntervalDao")
	private HibernateDaoImpl<CInterval, Long> cIntervalDao;
	
	@Transactional
	public void createCInterval(CInterval cInterval) {
		cIntervalDao.persist(cInterval);
	}
	
	@Transactional
	public void updateCInterval(CInterval cInterval) {
		cIntervalDao.merge(cInterval);
	}
	
	@Transactional
	public CInterval find(Long cIntervalId) {
		return cIntervalDao.find(cIntervalId);
	}
	
	@Transactional
	public CInterval findByDni(String dni) {
		return cIntervalDao.findByUniqueField("dni", dni);
	}
	@Transactional
	public List<CInterval> findAll() {
		List<CInterval> cIntervals = new ArrayList<CInterval>(cIntervalDao.findAll());
		return cIntervals;
	}
	
}
