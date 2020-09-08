package com.salesorder.microservices.saleorderservice.services;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesorder.microservices.saleorderservice.model.Item;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "item-service")
@RequestMapping("/item-service/api/service2")
public interface ItemService {

	@GetMapping("/items")
	public List<Item> getItemList();

	@GetMapping("/items/{itemname}")
	public Item getItemDetails(@PathVariable(value = "itemname") String name);
}
