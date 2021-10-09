package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerByCustomerId(int customerId);
    void deleteCustomer(int customerId);
}
