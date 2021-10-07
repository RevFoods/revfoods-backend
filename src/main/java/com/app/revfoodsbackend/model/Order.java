package com.app.revfoodsbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@OneToOne
	@JoinColumn(name = "orderStatusId", referencedColumnName = "orderStatusId")
	private OrderStatus orderStatus;
	
	@OneToOne
	@JoinColumn(name = "cartId", referencedColumnName = "cartId")
	private Cart cart;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "chefId", referencedColumnName = "chefId")
	private Chef chef;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "supervisorId", referencedColumnName = "supervisorId")
	private Supervisor supervisor;
	
}
