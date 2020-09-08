package com.salesorder.microservices.saleorderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesorder.microservices.saleorderservice.entity.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
	public List<SalesOrder> getOrderByEmailId(String emailId);
}
