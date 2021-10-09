package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }

    @DeleteMapping("/customer/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }

    @PutMapping("/customer/{customerId}/customerTable/{customerTableId}")
    public Customer addCustomerTableToCustomer(@PathVariable int customerTableId, @PathVariable int customerId) {
        return customerService.addCustomerTableToCustomer(customerTableId, customerId);
    }

    @GetMapping("/customers/orderStatus/{orderStatusId}")
    public List<Customer> getAllCustomersByOrderStatusId(@PathVariable int orderStatusId) {
        return customerService.getAllCustomersByOrderStatusId(orderStatusId);
    }

    @PutMapping("/customer/{customerId}/feedback")
    public Customer addFeedbackToCustomer(@PathVariable int customerId, @RequestBody Feedback feedback) {
        return customerService.addFeedbackToCustomer(customerId, feedback);
    }

    @PutMapping("/customer/{customerId}/help")
    public Customer addHelpToCustomer(@PathVariable int customerId,@RequestBody Help help) {
        return customerService.addHelpToCustomer(customerId, help);
    }
}
