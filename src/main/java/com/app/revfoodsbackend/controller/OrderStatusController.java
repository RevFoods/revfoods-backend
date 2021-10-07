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

import com.app.revfoodsbackend.model.OrderStatus;
import com.app.revfoodsbackend.service.OrderStatusService;

@RestController
@CrossOrigin
public class OrderStatusController {
	
	
	@Autowired
	private OrderStatusService orderStatusService;
	
	@PostMapping("/orderstatus")
	public OrderStatus addOrderStatus(@RequestBody OrderStatus orderStatus) {
		
	
		return orderStatusService.addOrderStatus(orderStatus);
	}
	
	@PutMapping("/orderstatus")
	public OrderStatus updateOrderStatus(@RequestBody OrderStatus orderStatus) {
		
	
		return orderStatusService.updateOrderStatus(orderStatus);
	}
	
	@DeleteMapping("/orderstatus/{orderStatusId}")
	public void deleteOrderStatus(@PathVariable int orderStatusId) {
		
	
		orderStatusService.deleteOrderStatus(orderStatusId);
	}

	@GetMapping("/orderstatus/{orderStatusId}")
	public OrderStatus getOrderStatusById(@PathVariable int orderStatusId) {
		
	
		return orderStatusService.getOrderStatusById(orderStatusId);
	}
	
	@GetMapping("/orderstatuses")
	public List<OrderStatus>  getAllStatuses() {
		
	
		return orderStatusService.getAllOrderStatuses();
	}
	
	

}
