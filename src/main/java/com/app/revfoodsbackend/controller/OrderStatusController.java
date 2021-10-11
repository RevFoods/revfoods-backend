package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.OrderStatus;
import com.app.revfoodsbackend.service.OrderStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Order Status Operations")
@RestController
@CrossOrigin
public class OrderStatusController {

	@Autowired
	private OrderStatusService orderStatusService;

	@ApiOperation(value = "To add the order status")
	@PostMapping("/orderstatus")
	public OrderStatus addOrderStatus(@RequestBody OrderStatus orderStatus) {
		return orderStatusService.addOrderStatus(orderStatus);
	}

	@ApiOperation(value = "To update the order status")
	@PutMapping("/orderstatus")
	public OrderStatus updateOrderStatus(@RequestBody OrderStatus orderStatus) {
		return orderStatusService.updateOrderStatus(orderStatus);
	}

	@ApiOperation(value = "To delete the order status")
	@DeleteMapping("/orderstatus/{orderStatusId}")
	public void deleteOrderStatus(@PathVariable int orderStatusId) {
		orderStatusService.deleteOrderStatus(orderStatusId);
	}

	@ApiOperation(value = "To get the order status by the order status Id")
	@GetMapping("/orderstatus/{orderStatusId}")
	public OrderStatus getOrderStatusById(@PathVariable int orderStatusId) {
		return orderStatusService.getOrderStatusById(orderStatusId);
	}

	@ApiOperation(value = "To get all the order statuses")
	@GetMapping("/orderstatuses")
	public List<OrderStatus> getAllOrderStatuses() {
		return orderStatusService.getAllOrderStatuses();
	}
}
