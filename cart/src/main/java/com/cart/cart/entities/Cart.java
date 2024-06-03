package com.cart.cart.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "cart", uniqueConstraints = {
	       @UniqueConstraint(columnNames = {"name"}) })
public class Cart {
// id, name, price, and quantity
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "cart name cannot be empty.")
	@Nonnull
	private String name;
	@Min(value = 1, message = "Quantity can not be less than 1.")
	@Nonnull
	private int quantity;
	@Nonnull
	@Min(value = 0,message="Price can not be less than 0")
	private double price;
}
