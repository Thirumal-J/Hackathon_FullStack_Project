package com.salesorder.microservices.saleorderservice.services;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesorder.microservices.saleorderservice.model.Customer;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "customer-service")
@RequestMapping("/customer-service/api/service1")
public interface CustomerService {
	
	@GetMapping("/customers")
	public List<Customer> getCustomerList();

	@GetMapping("/customers/email/{email}")
	public Customer getCustomerDetails(@PathVariable(value = "email") String email);
}
