package com.shopping.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.orderservice.dto.PaymentDTO;
import com.shopping.orderservice.dto.TransactionResponse;
import com.shopping.orderservice.entity.Order;
import com.shopping.orderservice.feign.PaymentFeign;
import com.shopping.orderservice.repository.OrderRepository;

@Service
public class OrderService {
 
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private PaymentFeign paymentFeign;
	
	public TransactionResponse saveOrder(Order order) {
		String message = "";
		PaymentDTO payment = new PaymentDTO();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice()*order.getQty());
		
		PaymentDTO paymentResponse = paymentFeign.doPayment(payment);
		
		message = paymentResponse.getPaymentStatus().equalsIgnoreCase("Success")?"Payment is Successful. Order Placed":"Payment Failure";
		orderRepo.save(order);
		return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), message);
	}
}
