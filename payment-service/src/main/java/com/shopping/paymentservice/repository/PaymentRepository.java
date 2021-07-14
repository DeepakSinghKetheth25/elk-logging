package com.shopping.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
