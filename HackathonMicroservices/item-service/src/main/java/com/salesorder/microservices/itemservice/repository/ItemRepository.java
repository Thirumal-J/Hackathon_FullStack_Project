package com.salesorder.microservices.itemservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesorder.microservices.itemservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	public Item getItemByName(String name);
}
