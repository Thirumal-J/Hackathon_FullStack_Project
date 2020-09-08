package com.salesorder.microservices.saleorderservice.model;

import java.util.Date;
import java.util.List;

public class UserOrder {

	private Date orderDate;
	private String emailId;
	private String description;
	private long price;
	private List<UserItems> order;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public List<UserItems> getOrder() {
		return order;
	}

	public void setOrder(List<UserItems> order) {
		this.order = order;
	}

}
