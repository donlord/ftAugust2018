package com.cooksys.cookbook.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({ NameNotAvailableException.class })
    public ResponseEntity<Object> handleNameNotAvailableException(NameNotAvailableException ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ RecipeNotFoundException.class })
    public ResponseEntity<Object> handleRecipeNotFoundException(RecipeNotFoundException ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT);
    }

}
