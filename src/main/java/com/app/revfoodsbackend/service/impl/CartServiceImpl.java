package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.repository.CartRepository;
import com.app.revfoodsbackend.service.CartService;
import com.app.revfoodsbackend.service.CustomerService;
import com.app.revfoodsbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FoodService foodService;

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByCartId(int cartId) {
        return cartRepository.findById(cartId).get();
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteCart(int cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public Cart addFoodAndCustomerToCart(int foodId, int customerId, int cartQuantity) {
        Customer customer = customerService.getCustomerByCustomerId(customerId);
        Food food = foodService.getFoodByFoodId(foodId);
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setFood(food);
        cart.setCartQuantity(cartQuantity);

        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCartsByCustomerId(int customerId) {
        Customer customer = customerService.getCustomerByCustomerId(customerId);
        return cartRepository.findCartsByCustomer(customer);
    }
}
