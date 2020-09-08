package com.salesorder.microservices.saleorderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesorder.microservices.saleorderservice.entity.OrderLineItem;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {
	public List<OrderLineItem> getItemByOrderId(Long id);
}
