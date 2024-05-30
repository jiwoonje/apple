package com.example.phoneShopping.member.exception;

import org.springframework.http.HttpStatus;

public class InfoException extends RuntimeException
{
	private HttpStatus status;
	
    public InfoException(String message, HttpStatus status) 
    {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() 
    {
        return status;
    }
}
