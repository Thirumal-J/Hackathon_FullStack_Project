package com.salesorder.microservices.saleorderservice.model;

import java.util.Date;
import java.util.List;

public class Order {
	private String description;
	private Date date;
	private String customerEmailId;
	private List<String> items;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [description=" + description + ", date=" + date + ", customerEmailId=" + customerEmailId
				+ ", items=" + items + "]";
	}

}
