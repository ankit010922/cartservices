package com.cart.cart.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cart.cart.entities.Cart;
import com.cart.cart.repository.CartRepository;

@Service
public class CartServicesImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	@Override
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}
	@Override
	public Page<Cart> getAllCart(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return cartRepository.findAll(pageable);
	}

}
