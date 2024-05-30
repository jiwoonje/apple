package com.example.phoneShopping.member.exception;

import org.springframework.http.HttpStatus;

public class CardException extends RuntimeException
{
	private HttpStatus status;
	
    public CardException(String message, HttpStatus status) 
    {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() 
    {
        return status;
    }
}
