package com.lucia.trucksmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucia.trucksmanagement.persistence.dao.HibernateDaoImpl;
import com.lucia.trucksmanagement.persistence.domain.Expense;

@Service
public class ExpenseService {

	@Resource(name="expenseDao")
	private HibernateDaoImpl<Expense, Long> expenseDao;
	
	@Transactional
	public void createExpense(Expense expense) {
		expenseDao.persist(expense);
	}
	
	@Transactional
	public void updateExpense(Expense expense) {
		expenseDao.merge(expense);
	}
	
	@Transactional
	public Expense find(Long expenseId) {
		return expenseDao.find(expenseId);
	}
	
	@Transactional
	public Expense findByDni(String dni) {
		return expenseDao.findByUniqueField("dni", dni);
	}
	
	@Transactional
	public List<Expense> findAll() {
		List<Expense> expenses = new ArrayList<Expense>(expenseDao.findAll());
		return expenses;
	}
}
