package com.salesorder.microservices.itemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesorder.microservices.itemservice.entity.Item;
import com.salesorder.microservices.itemservice.repository.ItemRepository;

@RestController
//@EnableHystrix
@RequestMapping("/api/service2")
public class ItemController {

	@Autowired
	ItemRepository repository;
	
	@GetMapping("/items")
	//@HystrixCommand(fallbackMethod="fallback")
	public List<Item> getItemList(){
		
		return repository.findAll();
	}
	
	@GetMapping("/items/{itemname}")
	//@HystrixCommand(fallbackMethod="fallback")
	public Item getItemDetails(@PathVariable(value = "itemname") String name){
		Item item = null;
		item = repository.getItemByName(name);
		return item;
	}
	
	/*private static Object fallback() {
		return "Sorry! Somting went wrong";
	}*/
}
