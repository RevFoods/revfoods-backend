package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.FoodOrder;
import com.app.revfoodsbackend.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    @PostMapping("/order")
    public FoodOrder addFoodOrder(@RequestBody FoodOrder foodOrder) {
        return foodOrderService.addFoodOrder(foodOrder);
    }

    @GetMapping("/order/{orderId}")
    public FoodOrder getFoodOrderById(@PathVariable int orderId) {
        return foodOrderService.getFoodOrderById(orderId);
    }

    @DeleteMapping("/order/{orderId}")
    public void deleteFoodOrder(@PathVariable int orderId) {
        foodOrderService.deleteFoodOrder(orderId);
    }

    @PutMapping("/order")
    public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder) {
        return foodOrderService.updateFoodOrder(foodOrder);
    }

    @GetMapping("/orders")
    public List<FoodOrder> getAllFoodOrders() {
        return foodOrderService.getAllFoodOrders();
    }

    @PostMapping("/order/cart/{cartId}")
    public FoodOrder addCartToFoodOrder(@PathVariable int cartId) {
        return foodOrderService.addCartToFoodOrder(cartId);
    }

    @GetMapping("/orders/customer/{customerId}")
    public List<FoodOrder> getFoodOrdersByCustomerId(@PathVariable int customerId) {
        return foodOrderService.getFoodOrdersByCustomerId(customerId);
    }

    @PutMapping("/order/{orderId}/orderStatus/{orderStatusId}")
    public FoodOrder updateFoodOrderStatus(@PathVariable int orderId,@PathVariable int orderStatusId) {
        return foodOrderService.updateFoodOrderStatus(orderId, orderStatusId);
    }

    @GetMapping("/orders/orderStatus/{orderStatusId}")
    public List<FoodOrder> getAllFoodOrdersByOrderStatusId(@PathVariable int orderStatusId) {
        return foodOrderService.getAllFoodOrdersByOrderStatusId(orderStatusId);
    }
}
