package com.shopping.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.orderservice.dto.PaymentDTO;
import com.shopping.orderservice.dto.TransactionResponse;
import com.shopping.orderservice.entity.Order;
import com.shopping.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
}
