package com.app.revfoodsbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int cartQuantity;
	
	@ManyToOne
	@JoinColumn(name="customerId", referencedColumnName = "customerId")
	Customer customer;
	
	@ManyToOne
	@JoinColumn(name="foodId", referencedColumnName = "foodId")
	Food food;
}
