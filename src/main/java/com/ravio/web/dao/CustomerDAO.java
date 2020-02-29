package com.ravio.web.dao;

import java.util.List;

import com.ravio.web.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(Customer theCustomer);

}
