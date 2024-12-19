package com.example.demo_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EntityToUpdateHasNoIdException extends RuntimeException{
    public EntityToUpdateHasNoIdException(String errorMessage) {
        super(errorMessage);
    }
}
