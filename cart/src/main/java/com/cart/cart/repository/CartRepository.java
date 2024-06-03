package com.cart.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.cart.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
