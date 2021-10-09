package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.repository.CustomerRepository;
import com.app.revfoodsbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer getCustomerByCustomerId(int customerId) {
        return repository.findById(customerId).get();
    }

    @Override
    public void deleteCustomer(int customerId) {
        repository.deleteById(customerId);
    }
}
