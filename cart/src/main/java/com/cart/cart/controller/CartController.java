package com.cart.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart.cart.entities.Cart;
import com.cart.cart.response.Response;
import com.cart.cart.services.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
@Validated
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/items")
	public ResponseEntity<Response<Cart>> addToCart(@Valid @RequestBody Cart cart){
		String message = cartService.addCart(cart)!=null ?"Added successfully":"Something went wrong";
		Response<Cart> reposne = new Response<Cart>(message, 200, cart);
		return new ResponseEntity<Response<Cart>>(reposne,HttpStatus.CREATED);
	}
	@GetMapping("/items")
	public ResponseEntity<Response<Page<Cart>>> getAllCartItems(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size){
		Page<Cart> carts = cartService.getAllCart(page, size);
		Response<Page<Cart>> response = new Response<Page<Cart>>("fetched", 200, carts);
				return new ResponseEntity<Response<Page<Cart>>>(response,HttpStatus.OK);
		
	}
	
}
