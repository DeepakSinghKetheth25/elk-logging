package com.shopping.paymentservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.paymentservice.entity.Payment;
import com.shopping.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired 
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	public String paymentProcessing() {
		//api should be 3rd party payment gateway(paypal, paytm)..
		return new Random().nextBoolean()?"Success" : "Failure" ;
	}
}
