package com.salesorder.microservices.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesorder.microservices.customerservice.entity.Customer;
import com.salesorder.microservices.customerservice.repository.CustomerRepository;

@RestController
@RequestMapping("/api/service1")
public class CustomerController {

	@Autowired
	CustomerRepository repository;
	
	@GetMapping("/customers")
	public List<Customer> getCustomerList(){
		
		return repository.findAll();
	}
	
	@GetMapping("/customers/email/{email}")
	public Customer getCustomerDetails(@PathVariable(value = "email") String email){
		Customer customer = null;
		customer = repository.getCustomerByEmail(email);
		return customer;
	}
	

	
	/*private static Object fallback() {
		return "Sorry! Somting went wrong";
	}*/
	
}
