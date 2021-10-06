package com.app.revfoodsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.service.CartService;

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
	
}
