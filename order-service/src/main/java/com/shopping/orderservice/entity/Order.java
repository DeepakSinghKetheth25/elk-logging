package com.shopping.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	private String id;
	private String name;
	private int qty;
	private double price;
}
