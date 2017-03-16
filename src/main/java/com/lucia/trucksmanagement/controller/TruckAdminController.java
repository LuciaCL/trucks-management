package com.lucia.trucksmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucia.trucksmanagement.persistence.domain.Truck;
import com.lucia.trucksmanagement.service.GenericAdminService;

@Controller
@RequestMapping("/" + Urls.ADMIN_TRUCKS)
public class TruckAdminController extends 
	GenericAdminController<GenericAdminService<Truck,Long>, Truck, Long>{

	@Override
	public String getConcreteUrlPath() {
		return Urls.ADMIN_TRUCKS;
	}
	
	
	@RequestMapping(value="/onetruck",produces={"application/json"})
	public @ResponseBody Truck getTruck() {
		Truck truck = new Truck();
		truck.setPlateNumber("AAAA");
		truck.setId((long) 1);
		truck.setModel("IVECO");
		return truck;
	}
	
}
