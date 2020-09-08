package com.salesorder.microservices.saleorderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_line_item")
public class OrderLineItem {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "quantity")
	private long quantity;

	@Column(name = "order_id")
	private long orderId;

	public OrderLineItem() {
		super();
	}

	public OrderLineItem(String itemName, long quantity, long orderId) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
