package com.shopping.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.orderservice.dto.PaymentDTO;

@FeignClient(name = "payment-feign", url = "${payment-url}")
public interface PaymentFeign {
	
	@PostMapping("/doPayment")
	public PaymentDTO doPayment(@RequestBody PaymentDTO payment);
}
