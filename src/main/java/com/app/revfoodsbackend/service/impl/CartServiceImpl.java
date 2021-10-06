package com.app.revfoodsbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.repository.CartRepository;
import com.app.revfoodsbackend.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
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
		return cartRepository.getById(cartId);
	}

	@Override
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	@Override
	public void deleteCart(int cartId) {
		cartRepository.deleteById(cartId);
	}
	
}
