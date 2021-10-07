package com.app.revfoodsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.revfoodsbackend.model.Order;
import com.app.revfoodsbackend.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	@GetMapping("/order/{orderId}")
	public Order getBusById(@PathVariable int orderId) {
		return orderService.getOrderById(orderId);
	}
	
	@DeleteMapping("/order/{orderId}")
	public void deleteOrder(@PathVariable int orderId) {
		orderService.deleteOrder(orderId);
	}

	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
}
