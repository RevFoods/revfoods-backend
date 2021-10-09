package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.OrderStatus;
import com.app.revfoodsbackend.repository.OrderStatusRepository;
import com.app.revfoodsbackend.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public OrderStatus addOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus updateOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public void deleteOrderStatus(int orderStatusId) {
        orderStatusRepository.deleteById(orderStatusId);
    }

    @Override
    public OrderStatus getOrderStatusById(int orderStatusId) {
        return orderStatusRepository.findById(orderStatusId).get();
    }

    @Override
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusRepository.findAll();
    }

}
