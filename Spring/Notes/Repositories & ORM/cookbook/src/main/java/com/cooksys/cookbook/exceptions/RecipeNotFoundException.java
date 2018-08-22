package com.cooksys.cookbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "No such Recipe")
public class RecipeNotFoundException extends RuntimeException {

}
