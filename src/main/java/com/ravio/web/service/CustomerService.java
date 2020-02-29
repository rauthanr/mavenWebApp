package com.ravio.web.service;

import java.util.List;

import com.ravio.web.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);

	public void deleteCustomer(Customer theCustomer);

}
