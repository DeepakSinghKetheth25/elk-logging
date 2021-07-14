package com.shopping.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

}
