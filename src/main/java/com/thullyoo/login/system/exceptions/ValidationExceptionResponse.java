package com.thullyoo.login.system.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ValidationExceptionResponse(List<String> validationsErrors, HttpStatus status) {
}
