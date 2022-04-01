package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String s) {
        super(s);
    }
}
