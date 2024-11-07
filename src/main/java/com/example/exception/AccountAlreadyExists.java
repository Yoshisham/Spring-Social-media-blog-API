package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason = "Account already exists")
public class AccountAlreadyExists extends RuntimeException{
    private String message;

    public AccountAlreadyExists() {}

    public AccountAlreadyExists(String msg) {
        super(msg) ;
        this.message = msg;
    }
    
}
