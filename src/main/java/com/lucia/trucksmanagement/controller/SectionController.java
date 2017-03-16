package com.lucia.trucksmanagement.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucia.trucksmanagement.persistence.domain.Section;
import com.lucia.trucksmanagement.service.SectionService;

@Controller
@RequestMapping("/sections")
public class SectionController {

	@Resource
	private SectionService sectionService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getCreateSectionForm(ModelMap modelMap) {
		
		Section sectionForm = new Section();
		modelMap.addAttribute("sectionForm", sectionForm);
		return "createSection";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String submitCreateSectionForm(@ModelAttribute("sectionForm") Section section, ModelMap modelMap) {
		
		// validate section 
		
		sectionService.createSection(section);
		
		return "success";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(ModelMap modelMap) {
		
		List<Section> sections = sectionService.findAll();
		
		modelMap.addAttribute("sections", sections);
		return "sections/list";
	}
}
