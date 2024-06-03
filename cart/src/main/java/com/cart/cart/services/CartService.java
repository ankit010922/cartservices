package com.cart.cart.services;

import org.springframework.data.domain.Page;

import com.cart.cart.entities.Cart;

public interface CartService {

	public Cart addCart(Cart cart);
	public Page<Cart> getAllCart(int page,int size);
}
