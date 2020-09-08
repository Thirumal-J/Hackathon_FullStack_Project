package com.salesorder.microservices.saleorderservice.model;

public class UserItems {
	private String itemName;
	private long quantity;
	private long orderId;
	
	public UserItems() {
		
	}
	public UserItems(String itemName, long quantity, long orderId) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.orderId = orderId;
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
