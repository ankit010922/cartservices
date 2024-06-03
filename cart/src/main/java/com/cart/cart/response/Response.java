package com.cart.cart.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {

	private String message;
	private int status;
	private T data;
}
