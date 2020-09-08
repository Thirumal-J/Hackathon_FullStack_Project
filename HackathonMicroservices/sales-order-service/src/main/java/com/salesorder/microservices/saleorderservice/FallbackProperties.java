package com.salesorder.microservices.saleorderservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("fallback")
public class FallbackProperties {
	private String order_email;
	private String order_description;
	private String item_name;

	public String getOrder_email() {
		return order_email;
	}

	public void setOrder_email(String order_email) {
		this.order_email = order_email;
	}

	public String getOrder_description() {
		return order_description;
	}

	public void setOrder_description(String order_description) {
		this.order_description = order_description;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

}
