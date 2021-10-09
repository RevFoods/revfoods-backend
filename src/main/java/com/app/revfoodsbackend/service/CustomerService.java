package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.Feedback;
import com.app.revfoodsbackend.model.Help;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerByCustomerId(int customerId);
    void deleteCustomer(int customerId);
    Customer addCustomerTableToCustomer(int customerTableId, int customerId);
    List<Customer> getAllCustomersByOrderStatusId(int orderStatusId);
    Customer addFeedbackToCustomer(int customerId, Feedback feedback);
    Customer addHelpToCustomer(int customerId, Help help);
}
