package com.salesorder.microservices.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesorder.microservices.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	public Customer getCustomerByEmail(String Email);
}
