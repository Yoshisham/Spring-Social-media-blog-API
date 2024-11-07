package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason = "Login not successful")
public class UnauthorizedLogin extends RuntimeException {
    public UnauthorizedLogin() {}
}
