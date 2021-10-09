package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    @PutMapping("/cart")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @GetMapping("/cart/{cartId}")
    public Cart getCartByCartId(@PathVariable int cartId) {
        return cartService.getCartByCartId(cartId);
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @DeleteMapping("/cart/{cartId}")
    public void deleteCart(@PathVariable int cartId) {
        cartService.deleteCart(cartId);
    }

    @PostMapping("/cart/customer/{customerId}/food/{foodId}/cartQuantity/{cartQuantity}")
    public Cart addFoodAndCustomerToCart(@PathVariable int foodId, @PathVariable int customerId,@PathVariable int cartQuantity) {
        return cartService.addFoodAndCustomerToCart(foodId, customerId, cartQuantity);
    }

    @GetMapping("/cart/customer/{customerId}")
    public List<Cart> getAllCartsByCustomerId(@PathVariable int customerId) {
        return cartService.getAllCartsByCustomerId(customerId);
    }
}
