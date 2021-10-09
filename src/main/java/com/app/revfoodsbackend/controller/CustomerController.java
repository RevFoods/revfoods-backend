package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        return service.getCustomerByCustomerId(customerId);
    }

    @DeleteMapping("/customer/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        service.deleteCustomer(customerId);
    }

}
