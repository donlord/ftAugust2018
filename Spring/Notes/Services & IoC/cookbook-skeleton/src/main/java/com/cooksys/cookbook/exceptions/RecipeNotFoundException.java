package com.cooksys.cookbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends RuntimeException {

    private Integer id;

    public RecipeNotFoundException (Integer id) {
        this.id = id;
    }

    @Override
    public String getMessage () {
        return "Recipe with id: " + this.id + " does not exist.";
    }

}
