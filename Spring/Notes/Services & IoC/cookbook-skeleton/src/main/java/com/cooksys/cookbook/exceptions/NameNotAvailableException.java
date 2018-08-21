package com.cooksys.cookbook.exceptions;

public class NameNotAvailableException extends Exception {

    private String name;

    public NameNotAvailableException (String name) {
        this.name = name;
    }

    @Override
    public String getMessage () {
        return name + " is already in use!";
    }
}
