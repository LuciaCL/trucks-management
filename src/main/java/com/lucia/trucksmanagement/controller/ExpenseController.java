package com.lucia.trucksmanagement.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lucia.trucksmanagement.persistence.domain.Expense;
import com.lucia.trucksmanagement.service.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

	@Resource
	private ExpenseService expenseService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getCreateExpenseForm(ModelMap modelMap) {
		
		Expense expenseForm = new Expense();
		modelMap.addAttribute("expenseForm", expenseForm);
		return "createExpense";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String submitCreateExpenseForm(@ModelAttribute("expenseForm") Expense expense, ModelMap modelMap) {
		
		// validate expense 
		
		expenseService.createExpense(expense);
		
		return "success";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(ModelMap modelMap) {
		
		List<Expense> expenses = expenseService.findAll();
		
		modelMap.addAttribute("expenses", expenses);
		return "expenses/list";
	}
}
