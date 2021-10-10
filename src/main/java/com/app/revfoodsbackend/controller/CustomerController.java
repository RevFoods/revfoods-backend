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

import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(description = "Customer Operations")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "To add a new customer")
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@ApiOperation(value = "To update the customer info")
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@ApiOperation(value = "To get all customers")
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@ApiOperation(value = "To get customer by id")
	@GetMapping("/customer/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		return customerService.getCustomerByCustomerId(customerId);
	}

	@ApiOperation(value = "To delete the customer")
	@DeleteMapping("/customer/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}

	@ApiOperation(value = "To add the CustomerTable in the Customer")
	@PutMapping("/customer/{customerId}/customerTable/{customerTableId}")
	public Customer addCustomerTableToCustomer(@PathVariable int customerTableId, @PathVariable int customerId) {
		return customerService.addCustomerTableToCustomer(customerTableId, customerId);
	}

	@ApiOperation(value = "To get the customers by the order status")
	@GetMapping("/customers/orderStatus/{orderStatusId}")
	public List<Customer> getAllCustomersByOrderStatusId(@PathVariable int orderStatusId) {
		return customerService.getAllCustomersByOrderStatusId(orderStatusId);
	}

	@ApiOperation(value = "To add the customer feedback")
	@PutMapping("/customer/{customerId}/feedback")
	public Customer addFeedbackToCustomer(@PathVariable int customerId, @RequestBody Feedback feedback) {
		return customerService.addFeedbackToCustomer(customerId, feedback);
	}

	@ApiOperation(value = "To add the customer help")
	@PutMapping("/customer/{customerId}/help")
	public Customer addHelpToCustomer(@PathVariable int customerId, @RequestBody Help help) {
		return customerService.addHelpToCustomer(customerId, help);
	}
}
