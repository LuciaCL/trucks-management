package com.lucia.trucksmanagement.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucia.trucksmanagement.persistence.domain.Carrier;
import com.lucia.trucksmanagement.service.CarrierService;

@Controller
@RequestMapping("/carriers")
public class CarrierController {

	@Resource
	private CarrierService carrierService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getCreateCarrierForm(ModelMap modelMap) {
		
		Carrier carrierForm = new Carrier();
		modelMap.addAttribute("carrierForm", carrierForm);
		return "createCarrier";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String submitCreateCarrierForm(@ModelAttribute("carrierForm") Carrier carrier, ModelMap modelMap) {
		
		// validate Carrier 
		
		carrierService.createCarrier(carrier);
		
		return "redirect:/carriers/list";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(ModelMap modelMap) {
		
		List<Carrier> carriers = carrierService.findAll();
		
		modelMap.addAttribute("carriers", carriers);
		return "carriers/list";
	}
}
