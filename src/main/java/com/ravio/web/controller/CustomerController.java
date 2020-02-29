package com.ravio.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ravio.web.entity.Customer;
import com.ravio.web.service.CustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	//Inject the Service
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping(value="/list", method=RequestMethod.GET)
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//Create model attribute to bind form data
		Customer theCustomer = new Customer();
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer customer) {
		
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model model) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		customerService.deleteCustomer(theCustomer);
		return "redirect:/customer/list";
	}
}
