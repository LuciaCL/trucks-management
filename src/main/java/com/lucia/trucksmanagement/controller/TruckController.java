package com.lucia.trucksmanagement.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucia.trucksmanagement.persistence.domain.Truck;
import com.lucia.trucksmanagement.service.TruckService;

//@Controller
//@RequestMapping("/trucks")
public class TruckController {

	@Resource
	private TruckService truckService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getForm(ModelMap modelMap) {
		
		Truck truckForm = new Truck();
		modelMap.addAttribute("truckForm", truckForm);
		return "trucks/create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("truckForm") Truck truck, ModelMap modelMap) {
		
		// validate truck 
		
		truckService.createTruck(truck);
		
		return "redirect:/trucks/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(ModelMap modelMap) {
		
		List<Truck> trucks = truckService.findAll();
		
		modelMap.addAttribute("trucks", trucks);
		return "trucks/list";
	}
}
