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

import com.app.revfoodsbackend.model.FoodOrder;
import com.app.revfoodsbackend.service.FoodOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Food Order Operations")
@RestController
@CrossOrigin
public class FoodOrderController {

	@Autowired
	private FoodOrderService foodOrderService;

	@ApiOperation(value = "To add a new food order")
	@PostMapping("/foodOrder")
	public FoodOrder addFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.addFoodOrder(foodOrder);
	}

	@ApiOperation(value = "To get the food order by the food order Id")
	@GetMapping("/foodOrder/{foodOrderId}")
	public FoodOrder getFoodOrderById(@PathVariable int foodOrderId) {
		return foodOrderService.getFoodOrderById(foodOrderId);
	}

	@ApiOperation(value = "To dleete the food order")
	@DeleteMapping("/foodOrder/{foodOrderId}")
	public void deleteFoodOrder(@PathVariable int foodOrderId) {
		foodOrderService.deleteFoodOrder(foodOrderId);
	}

	@ApiOperation(value = "To update the food order ")
	@PutMapping("/foodOrder")
	public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.updateFoodOrder(foodOrder);
	}

	@ApiOperation(value = "To get all  the food orders")
	@GetMapping("/foodOrders")
	public List<FoodOrder> getAllFoodOrders() {
		return foodOrderService.getAllFoodOrders();
	}

	@ApiOperation(value = "To add the cart to  the food order")
	@PostMapping("/foodOrder/cart/{cartId}")
	public FoodOrder addCartToFoodOrder(@PathVariable int cartId) {
		return foodOrderService.addCartToFoodOrder(cartId);
	}

	@ApiOperation(value = "To get the food orders by the customer Id")
	@GetMapping("/foodOrders/customer/{customerId}")
	public List<FoodOrder> getFoodOrdersByCustomerId(@PathVariable int customerId) {
		return foodOrderService.getFoodOrdersByCustomerId(customerId);
	}

	@ApiOperation(value = "To update the food order status")
	@PutMapping("/foodOrder/{foodOrderId}/orderStatus/{orderStatusId}")
	public FoodOrder updateFoodOrderStatus(@PathVariable int foodOrderId, @PathVariable int orderStatusId) {
		return foodOrderService.updateFoodOrderStatus(foodOrderId, orderStatusId);
	}

	@ApiOperation(value = "To get all the food orders by the order status ")
	@GetMapping("/foodOrders/orderStatus/{orderStatusId}")
	public List<FoodOrder> getAllFoodOrdersByOrderStatusId(@PathVariable int orderStatusId) {
		return foodOrderService.getAllFoodOrdersByOrderStatusId(orderStatusId);
	}
}
