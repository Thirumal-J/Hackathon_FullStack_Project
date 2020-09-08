package com.salesorder.microservices.saleorderservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales_order")
public class SalesOrder {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private long price;

	public SalesOrder() {

	}

	public SalesOrder(Date date, String emailId, String description, long price) {
		this.date = date;
		this.emailId = emailId;
		this.description = description;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

}
