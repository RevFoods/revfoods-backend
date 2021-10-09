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

    @PostMapping("/foodOrder")
    public FoodOrder addFoodOrder(@RequestBody FoodOrder foodOrder) {
        return foodOrderService.addFoodOrder(foodOrder);
    }

    @GetMapping("/foodOrder/{foodOrderId}")
    public FoodOrder getFoodOrderById(@PathVariable int foodOrderId) {
        return foodOrderService.getFoodOrderById(foodOrderId);
    }

    @DeleteMapping("/foodOrder/{foodOrderId}")
    public void deleteFoodOrder(@PathVariable int foodOrderId) {
        foodOrderService.deleteFoodOrder(foodOrderId);
    }

    @PutMapping("/foodOrder")
    public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder) {
        return foodOrderService.updateFoodOrder(foodOrder);
    }

    @GetMapping("/foodOrders")
    public List<FoodOrder> getAllFoodOrders() {
        return foodOrderService.getAllFoodOrders();
    }

    @PostMapping("/foodOrder/cart/{cartId}")
    public FoodOrder addCartToFoodOrder(@PathVariable int cartId) {
        return foodOrderService.addCartToFoodOrder(cartId);
    }

    @GetMapping("/foodOrders/customer/{customerId}")
    public List<FoodOrder> getFoodOrdersByCustomerId(@PathVariable int customerId) {
        return foodOrderService.getFoodOrdersByCustomerId(customerId);
    }

    @PutMapping("/foodOrder/{foodOrderId}/orderStatus/{orderStatusId}")
    public FoodOrder updateFoodOrderStatus(@PathVariable int foodOrderId,@PathVariable int orderStatusId) {
        return foodOrderService.updateFoodOrderStatus(foodOrderId, orderStatusId);
    }

    @GetMapping("/foodOrders/orderStatus/{orderStatusId}")
    public List<FoodOrder> getAllFoodOrdersByOrderStatusId(@PathVariable int orderStatusId) {
        return foodOrderService.getAllFoodOrdersByOrderStatusId(orderStatusId);
    }
}
