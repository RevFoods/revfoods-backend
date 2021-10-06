package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.Customer;

public interface CustomerService {
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	List<Customer> getAllCustomers();
     	Customer getCustomerByCustomerId(int customerId);
	void deleteCustomer(int customerId); 
}
