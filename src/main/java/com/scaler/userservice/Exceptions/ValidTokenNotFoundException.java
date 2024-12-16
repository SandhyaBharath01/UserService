package com.scaler.userservice.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ValidTokenNotFoundException extends Exception {
    public ValidTokenNotFoundException(String message){
        super(message);
    }
}
