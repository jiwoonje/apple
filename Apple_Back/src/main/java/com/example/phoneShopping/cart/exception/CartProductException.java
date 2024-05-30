package com.example.phoneShopping.cart.exception;

import org.springframework.http.HttpStatus;

public class CartProductException extends RuntimeException
{
	private HttpStatus status;
	
    public CartProductException(String message, HttpStatus status) 
    {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() 
    {
        return status;
    }
}
