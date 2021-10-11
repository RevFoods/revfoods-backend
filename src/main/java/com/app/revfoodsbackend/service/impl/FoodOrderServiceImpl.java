package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.*;
import com.app.revfoodsbackend.repository.CartRepository;
import com.app.revfoodsbackend.repository.CustomerRepository;
import com.app.revfoodsbackend.repository.FoodOrderRepository;
import com.app.revfoodsbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ChefService chefService;

    @Autowired
    private SupervisorService supervisorService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public FoodOrder addFoodOrder(FoodOrder foodOrder) {
        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public FoodOrder getFoodOrderById(int foodOrderId) {
        return foodOrderRepository.findById(foodOrderId).get();
    }

    @Override
    public void deleteFoodOrder(int foodOrderId) {
        foodOrderRepository.deleteById(foodOrderId);
    }

    @Override
    public List<FoodOrder> getAllFoodOrders() {
        return foodOrderRepository.findAll();
    }

    @Override
    public FoodOrder addCartToFoodOrder(int cartId) {
        Cart cart = cartService.getCartByCartId(cartId);
        Chef chef = chefService.getChefById(1);
        Supervisor supervisor = supervisorService.getSupervisorBySupervisorId(1);
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(1);

        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setCart(cart);
        foodOrder.setChef(chef);
        foodOrder.setSupervisor(supervisor);
        foodOrder.setOrderStatus(orderStatus);

        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public List<FoodOrder> getFoodOrdersByCustomerId(int customerId) {
        Customer customer = customerService.getCustomerByCustomerId(customerId);
        List<Cart> cartList = cartRepository.findCartsByCustomer(customer);

        List<FoodOrder> foodOrderList = new ArrayList<>();

        for (Cart cart : cartList) {
            if (foodOrderRepository.existsFoodOrderByCart(cart)) {
                FoodOrder foodOrder = foodOrderRepository.findFoodOrderByCart(cart);
                foodOrderList.add(foodOrder);
            }
        }

        return foodOrderList;
    }

    @Override
    public FoodOrder updateFoodOrderStatus(int foodOrderId, int orderStatusId) {
        FoodOrder foodOrder = foodOrderRepository.findById(foodOrderId).get();
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(orderStatusId);
        foodOrder.setOrderStatus(orderStatus);
        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public List<FoodOrder> getAllFoodOrdersByOrderStatusId(int orderStatusId) {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(orderStatusId);
        return foodOrderRepository.findAllByOrderStatus(orderStatus);
    }
}
