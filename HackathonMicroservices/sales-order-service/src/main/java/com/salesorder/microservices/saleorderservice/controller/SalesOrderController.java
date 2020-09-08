package com.salesorder.microservices.saleorderservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.salesorder.microservices.saleorderservice.FallbackProperties;
import com.salesorder.microservices.saleorderservice.entity.OrderLineItem;
import com.salesorder.microservices.saleorderservice.entity.SalesOrder;
import com.salesorder.microservices.saleorderservice.model.Customer;
import com.salesorder.microservices.saleorderservice.model.Item;
import com.salesorder.microservices.saleorderservice.model.Order;
import com.salesorder.microservices.saleorderservice.model.UserItems;
import com.salesorder.microservices.saleorderservice.model.UserOrder;
import com.salesorder.microservices.saleorderservice.repository.OrderLineItemRepository;
import com.salesorder.microservices.saleorderservice.repository.SalesOrderRepository;
import com.salesorder.microservices.saleorderservice.services.CustomerService;
import com.salesorder.microservices.saleorderservice.services.ItemService;

@RestController
@EnableHystrix
@RequestMapping(value = "/api/service3")
public class SalesOrderController {

	@Autowired
	FallbackProperties fallbackProperties;
	
	@Autowired
	CustomerService customerService;

	@Autowired
	ItemService itemService;

	@Autowired
	SalesOrderRepository salesOrderRepository;

	@Autowired
	OrderLineItemRepository orderLineItemRepository;

	@PostMapping(value = "/orders")
	@HystrixCommand(fallbackMethod = "placeOrderFallback")
	public long placeOrder(@RequestBody Order order) {
		boolean validationFlag = true;
		long totalPrice = 0l;
		List<Item> itemDetails = new ArrayList<Item>();
		// validate customer
		Customer customerDetails = customerService.getCustomerDetails(order.getCustomerEmailId() + "/");
		if (!(customerDetails.getEmail().equals(order.getCustomerEmailId()))) {
			validationFlag = false;
		}
		// validate items
		if (validationFlag) {
			Item temp = null;
			for (String itemName : order.getItems()) {
				temp = itemService.getItemDetails(itemName);
				if (temp.getName().equals(itemName)) {
					itemDetails.add(temp);
					totalPrice += temp.getPrice();
				} else {
					validationFlag = false;
					break;
				}
			}
		}

		// save data
		if(validationFlag) {
		SalesOrder salesOrder = new SalesOrder(order.getDate(), order.getCustomerEmailId(), order.getDescription(),
				totalPrice);
		salesOrder = salesOrderRepository.save(salesOrder);

		Map<String, OrderLineItem> orderMap = new HashMap<String, OrderLineItem>();
		OrderLineItem temp1 = null;
		for (Item item : itemDetails) {
			temp1 = null;
			if (orderMap.containsKey(item.getName())) {
				temp1 = orderMap.get(item.getName());
				orderMap.remove(item.getName());
				temp1.setQuantity(temp1.getQuantity() + 1l);
				orderMap.put(item.getName(), temp1);
			} else {
				temp1 = new OrderLineItem(item.getName(), 1l, salesOrder.getId());
				orderMap.put(item.getName(), temp1);
			}
		}
		orderLineItemRepository.save(orderMap.values());
		return salesOrder.getId();
		}else {
			throw new RuntimeException();
		}
		//System.out.println(order.toString() + "\n" + orderMap.values());

		// System.out.println(customerService.getCustomerDetails("rob@email.com/"));
		
	}

	@GetMapping(value = "/orders/{emailId}")
	@HystrixCommand(fallbackMethod = "getOrderByIdFallback")
	public List<UserOrder> getOrderById(@PathVariable(value = "emailId") String emailId) {
		List<SalesOrder> orders = salesOrderRepository.getOrderByEmailId(emailId);
		List<UserOrder> userOrders = new ArrayList<>();
		if (orders.size() > 0) {
			UserOrder temp = null;
			for (SalesOrder s : orders) {
				temp = new UserOrder();
				temp.setDescription(s.getDescription());
				temp.setEmailId(s.getEmailId());
				temp.setOrderDate(s.getDate());
				temp.setPrice(s.getPrice());
				temp.setOrder(userItemMapper(orderLineItemRepository.getItemByOrderId(s.getId())));
				userOrders.add(temp);
			}
		} else {
			// no orders found
			throw new RuntimeException();
		}
		return userOrders;
	}

	private static List<UserItems> userItemMapper(List<OrderLineItem> orderList) {
		List<UserItems> items = new ArrayList<>();
		for (OrderLineItem item : orderList) {
			items.add(new UserItems(item.getItemName(), item.getQuantity(), item.getOrderId()));
		}

		return items;
	}

	@SuppressWarnings("unused")
	private long placeOrderFallback(Order order) {
		return 404l;
	}

	@SuppressWarnings("unused")
	private List<UserOrder> getOrderByIdFallback(String email) {
		UserItems item = new UserItems();
		item.setItemName(fallbackProperties.getItem_name());
		item.setOrderId(0);
		item.setQuantity(0);

		UserOrder order = new UserOrder();
		order.setOrderDate(new Date());
		order.setPrice(0);
		order.setEmailId(fallbackProperties.getOrder_email());
		order.setDescription(fallbackProperties.getOrder_description());
		order.setOrder(Arrays.asList(item));
		return Arrays.asList(order);
	}

}
