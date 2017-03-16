package com.lucia.trucksmanagement.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lucia.trucksmanagement.persistence.domain.Truck;

@Service
public class TruckAdminService implements GenericAdminService<Truck, Long>{

	@Resource
	private TruckService truckService;
	
	@Override
	public void create(Truck entity) {
		truckService.createTruck(entity);
		
	}

	@Override
	public Truck find(Long id) {
		return truckService.find(id);
	}

	@Override
	public void update(Truck entity) {
		truckService.updateTruck(entity);
		
	}

	@Override
	public void remove(Long id) {
		//TODO:
		
	}

	@Override
	public List<Truck> findAll() {
		return truckService.findAll();
	}

}
