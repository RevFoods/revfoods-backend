package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.OrderStatus;

public interface OrderStatusService {
	
	OrderStatus addOrderStatus(OrderStatus orderStatus);
	OrderStatus updateOrderStatus(OrderStatus orderStatus);
	void deleteOrderStatus(int orderStatusId);
	OrderStatus getOrderStatusById(int orderStatusId);
	List<OrderStatus> getAllOrderStatuses();
	

}
