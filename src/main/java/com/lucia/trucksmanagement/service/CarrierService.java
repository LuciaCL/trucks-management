package com.lucia.trucksmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucia.trucksmanagement.persistence.dao.HibernateDaoImpl;
import com.lucia.trucksmanagement.persistence.domain.Carrier;

@Service
public class CarrierService {

	
	@Resource(name="carrierDao")
	private HibernateDaoImpl<Carrier, Long> carrierDao;
	
	@Transactional
	public void createCarrier(Carrier carrier) {
		carrierDao.persist(carrier);
	}
	
	@Transactional
	public void updateCarrier(Carrier carrier) {
		carrierDao.merge(carrier);
	}
	
	@Transactional
	public Carrier find(Long carrierId) {
		return carrierDao.find(carrierId);
	}
	
	@Transactional
	public Carrier findByDni(String dni) {
		return carrierDao.findByUniqueField("dni", dni);
	}
	@Transactional
	public List<Carrier> findAll() {
		List<Carrier> carriers = new ArrayList<Carrier>(carrierDao.findAll());
		return carriers;
	}
	
}
