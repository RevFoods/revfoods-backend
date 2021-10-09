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
}
