package com.thullyoo.login.system.exceptions.global;

import com.thullyoo.login.system.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponse> validationError(MethodArgumentNotValidException e){
        List<String> validationsErrors = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((ex) -> {
            validationsErrors.add(ex.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ValidationExceptionResponse(validationsErrors, HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @ExceptionHandler(CredentialNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFound(CredentialNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(EmailOrPasswordInvalid.class)
    public ResponseEntity<ExceptionResponse> emailOrPasswordInvalid(EmailOrPasswordInvalid e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @ExceptionHandler(ProductIsPresentException.class)
    public ResponseEntity<ExceptionResponse> productIsPresent(ProductIsPresentException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @ExceptionHandler(UserIsPresentException.class)
    public ResponseEntity<ExceptionResponse> productIsPresent(UserIsPresentException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY));
    }
}

