package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Client Error")
public class ClientError extends RuntimeException {
    private String message;

    public ClientError() {}

    public ClientError(String msg) {
        super(msg) ;
        this.message = msg;
    }
}
