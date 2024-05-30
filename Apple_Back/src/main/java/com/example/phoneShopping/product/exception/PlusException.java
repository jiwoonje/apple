package com.example.phoneShopping.product.exception;

import org.springframework.http.HttpStatus;

public class PlusException extends RuntimeException
{
	private HttpStatus status;
	
    public PlusException(String message, HttpStatus status) 
    {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() 
    {
        return status;
    }
}
