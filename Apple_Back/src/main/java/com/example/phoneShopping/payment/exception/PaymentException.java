package com.example.phoneShopping.payment.exception;

import org.springframework.http.HttpStatus;

public class PaymentException extends RuntimeException {
	
	private HttpStatus status;

    public PaymentException(String message, HttpStatus status) 
    {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() 
    {
        return status;
    }
}
