package com.lucia.trucksmanagement.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucia.trucksmanagement.persistence.domain.CInterval;
import com.lucia.trucksmanagement.service.CIntervalService;

@Controller
@RequestMapping("/cIntervals")
public class CIntervalController {

	@Resource
	private CIntervalService cIntervalService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getCreateCIntervalForm(ModelMap modelMap) {
		
		CInterval cIntervalForm = new CInterval();
		modelMap.addAttribute("cIntervalForm", cIntervalForm);
		return "createCInterval";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String submitCreateCIntervalForm(@ModelAttribute("cIntervalForm") CInterval cInterval, ModelMap modelMap) {
		
		// validate CInterval 
		
		cIntervalService.createCInterval(cInterval);
		
		return "success";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(ModelMap modelMap) {
		
		List<CInterval> cIntervals = cIntervalService.findAll();
		
		modelMap.addAttribute("cIntervals", cIntervals);
		return "cIntervals/list";
	}
}
