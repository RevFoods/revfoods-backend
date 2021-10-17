package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.*;
import com.app.revfoodsbackend.repository.*;
import com.app.revfoodsbackend.service.CustomerService;
import com.app.revfoodsbackend.service.CustomerTableService;
import com.app.revfoodsbackend.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerTableService customerTableService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private CustomerTableRepository customerTableRepository;

    @Autowired
    private SupervisorService supervisorService;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByCustomerId(int customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer addCustomerTableToCustomer(int customerTableId, int customerId) {
        List<CustomerTable> customerTableList = customerTableRepository.findAllByCustomerTableStatus(false);

        CustomerTable customerTable = customerTableList.get(0);
        Customer customer = customerRepository.getById(customerId);
        customerTable.setCustomerTableStatus(true);
        customer.setCustomerTable(customerTable);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomersByOrderStatusId(int orderStatusId) {
        OrderStatus orderStatus = orderStatusRepository.getById(orderStatusId);
        List<FoodOrder> foodOrderList = foodOrderRepository.findAllByOrderStatus(orderStatus);

        List<Customer> customerList = new ArrayList<>();
        for (FoodOrder foodOrder : foodOrderList) {
            Cart cart = cartRepository.findCartByFoodOrder(foodOrder);
            Customer customer = cart.getCustomer();
            if (!customerList.contains(customer)) {
                customerList.add(customer);
            }
        }
        return customerList;
    }

    @Override
    public Customer addFeedbackToCustomer(int customerId, Feedback feedback) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setFeedback(feedback);
        return customerRepository.save(customer);
    }

    @Override
    public Customer addHelpToCustomer(int customerId, Help help) {
        Customer customer = customerRepository.getById(customerId);
        customer.setHelp(help);
        return customerRepository.save(customer);
    }
}
