package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.Cart;

public interface CartService {

	Cart addCart(Cart cart);
	Cart updateCart(Cart cart);
	Cart getCartByCartId(int cartId);
	List<Cart> getAllCarts();
	void deleteCart(int cartId);
}
