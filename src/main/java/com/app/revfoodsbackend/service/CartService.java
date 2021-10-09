package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.Cart;

import java.util.List;

public interface CartService {
    Cart addCart(Cart cart);
    Cart updateCart(Cart cart);
    Cart getCartByCartId(int cartId);
    List<Cart> getAllCarts();
    void deleteCart(int cartId);
}
