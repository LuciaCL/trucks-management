package com.lucia.trucksmanagement.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucia.trucksmanagement.persistence.domain.Trailer;
import com.lucia.trucksmanagement.service.TrailerService;

@Controller
@RequestMapping("/trailers")
public class TrailerController {

	@Resource
	private TrailerService trailerService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getCreateTrailerForm(ModelMap modelMap) {
		
		Trailer trailerForm = new Trailer();
		modelMap.addAttribute("trailerForm", trailerForm);
		return "createTrailer";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String submitCreateTrailerForm(@ModelAttribute("trailerForm") Trailer trailer, ModelMap modelMap) {
		
		// validate trailer 
		
		trailerService.createTrailer(trailer);
		
		return "success";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(ModelMap modelMap) {
		
		List<Trailer> trailers = trailerService.findAll();
		
		modelMap.addAttribute("trailers", trailers);
		return "trailers/list";
	}
}
