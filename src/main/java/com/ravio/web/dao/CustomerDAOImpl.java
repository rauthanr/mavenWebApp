package com.ravio.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ravio.web.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//Inject hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Creaet query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute the query
		List<Customer> customers = theQuery.getResultList();
		
		//return the result
		return customers;
	}



	@Override
	public void saveCustomer(Customer theCustomer) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		//save customer
		currentSession.saveOrUpdate(theCustomer);
		
	}



	@Override
	public Customer getCustomer(int id) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Customer  theCustomer = currentSession.get(Customer.class, id);
		
		//return the result
		return theCustomer;

	}



	@Override
	public void deleteCustomer(Customer theCustomer) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.delete(theCustomer);
		
		
	}

}
