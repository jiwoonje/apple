package com.example.phoneShopping.product.exception;

import org.springframework.http.HttpStatus;

public class ColorException extends RuntimeException
{
	private HttpStatus status;
	
    public ColorException(String message, HttpStatus status) 
    {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() 
    {
        return status;
    }
}
