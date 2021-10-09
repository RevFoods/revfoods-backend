package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.OrderStatus;
import com.app.revfoodsbackend.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusService.getAllOrderStatuses();
    }
}
