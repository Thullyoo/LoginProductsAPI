package com.thullyoo.login.system.exceptions;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(String message, HttpStatus httpStatus) {
}
