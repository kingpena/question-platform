package com.demo.question_platform.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private String message;

    // Constructor
    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    // Getters and Setters (optional)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

