package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.Order;

public interface OrderService {
	
	Order addOrder(Order order);
	Order updateOrder(Order order);
	Order getOrderById(int orderId);
	void deleteOrder(int orderId);
	List<Order> getAllOrders();
	
}
