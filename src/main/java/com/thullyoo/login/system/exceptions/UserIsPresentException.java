package com.thullyoo.login.system.exceptions;

public class UserIsPresentException extends RuntimeException{

    public UserIsPresentException(String message) {
        super(message);
    }
}
