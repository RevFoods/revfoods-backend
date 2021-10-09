package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    OrderStatus addOrderStatus(OrderStatus orderStatus);
    OrderStatus updateOrderStatus(OrderStatus orderStatus);
    void deleteOrderStatus(int orderStatusId);
    OrderStatus getOrderStatusById(int orderStatusId);
    List<OrderStatus> getAllOrderStatuses();
}
