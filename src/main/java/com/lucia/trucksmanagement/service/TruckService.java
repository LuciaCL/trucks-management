package com.lucia.trucksmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucia.trucksmanagement.persistence.dao.HibernateDaoImpl;
import com.lucia.trucksmanagement.persistence.domain.Truck;

@Service
public class TruckService {

	@Resource(name="truckDao")
	private HibernateDaoImpl<Truck, Long> truckDao;
	
	private Logger LOG = LoggerFactory.getLogger(TruckService.class);
	
	@Transactional
	public void createTruck(Truck truck) {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Attempting to persist truck with plateNumber " + truck.getPlateNumber());
		}
		
		truckDao.persist(truck);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Persisted truck with id " + truck.getId());
		}
	}
	
	@Transactional
	public void updateTruck(Truck truck) {
		truckDao.merge(truck);
	}
	
	@Transactional
	public Truck find(Long truckId) {
		return truckDao.find(truckId);
	}
	
	@Transactional
	public Truck findByPlateNumber(String plateNumber) {
		return truckDao.findByUniqueField("plateNumber", plateNumber);
	}
	
	@Transactional
	public List<Truck> findAll() {
		List<Truck> trucks = new ArrayList<Truck>(truckDao.findAll());
		return trucks;
	}
	
	
}
