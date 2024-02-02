package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;

	public List<Customer> viewAll() {
		
		return customerDAO.viewAll();
	}

	@Transactional
	public void saveCustomer(Customer customer) {
		System.out.println("IN SERVICE: " + customer);
		customerDAO.saveCustomer(customer);

	}
	
	@Transactional
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);

	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);

	}

}
