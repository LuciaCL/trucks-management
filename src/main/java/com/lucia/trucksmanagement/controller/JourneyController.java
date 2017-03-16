package com.lucia.trucksmanagement.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucia.trucksmanagement.persistence.domain.Journey;
import com.lucia.trucksmanagement.service.JourneyService;

@Controller
@RequestMapping("/journeys")
public class JourneyController {

	@Resource
	private JourneyService journeyService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getCreateJourneyForm(ModelMap modelMap) {
		
		Journey journeyForm = new Journey();
		modelMap.addAttribute("journeyForm", journeyForm);
		return "createJourney";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String submitCreateJourneyForm(@ModelAttribute("journeyForm") Journey journey, ModelMap modelMap) {
		
		// validate journey 
		
		journeyService.createJourney(journey);
		
		return "success";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(ModelMap modelMap) {
		
		List<Journey> journeys = journeyService.findAll();
		
		modelMap.addAttribute("journeys", journeys);
		return "journeys/list";
	}
}
