package com.example.phoneShopping.cart.exception;

import org.springframework.http.HttpStatus;

public class CartException extends RuntimeException
{
	private HttpStatus status;
	
    public CartException(String message, HttpStatus status) 
    {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() 
    {
        return status;
    }
}
