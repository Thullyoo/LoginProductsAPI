package com.thullyoo.login.system.exceptions.global;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(String message, HttpStatus httpStatus) {
}
