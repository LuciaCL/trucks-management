package com.lucia.trucksmanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucia.trucksmanagement.persistence.dao.HibernateDaoImpl;
import com.lucia.trucksmanagement.persistence.domain.Customer;

@Service
public class CustomerService {

	@Resource(name="customerDao")
	private HibernateDaoImpl<Customer, Long> customerDao;
	
	@Transactional
	public void createCustomer(Customer customer) {
		customerDao.persist(customer);
	}
	
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDao.merge(customer);
	}
	
	@Transactional
	public Customer find(Long customerId) {
		return customerDao.find(customerId);
	}
	
	@Transactional
	public Customer findByCif(String cif) {
		return customerDao.findByUniqueField("cif", cif);
	}
	
	@Transactional
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>(customerDao.findAll());
		return customers;
	}
}
