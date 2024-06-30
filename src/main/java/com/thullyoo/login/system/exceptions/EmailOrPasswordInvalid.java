package com.thullyoo.login.system.exceptions;

public class EmailOrPasswordInvalid extends RuntimeException {
    public EmailOrPasswordInvalid(String message) {
        super(message);
    }
}
