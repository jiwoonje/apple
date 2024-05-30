package com.example.phoneShopping.payment.exception;

import org.springframework.http.HttpStatus;

public class PaymentProductException extends RuntimeException {
	
	private HttpStatus status;
	
	public PaymentProductException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

}
