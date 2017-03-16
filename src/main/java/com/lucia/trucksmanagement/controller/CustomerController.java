package com.lucia.trucksmanagement.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucia.trucksmanagement.persistence.domain.Customer;
import com.lucia.trucksmanagement.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Resource
	private CustomerService customerService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getCreateCustomerForm(ModelMap modelMap) {
		
		Customer customerForm = new Customer();
		modelMap.addAttribute("customerForm", customerForm);
		return "createCustomer";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String submitCreateCustomerForm(@ModelAttribute("customerForm") Customer customer, ModelMap modelMap) 
	{
		
		// validate customer 
		
		customerService.createCustomer(customer);
		
		return "success";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(ModelMap modelMap) {
		
		List<Customer> customers = customerService.findAll();
		
		modelMap.addAttribute("customers", customers);
		return "customers/list";
	}
}
