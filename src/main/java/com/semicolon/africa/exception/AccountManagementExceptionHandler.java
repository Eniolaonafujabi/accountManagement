package com.semicolon.africa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AccountManagementExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AccountManagementSystemException.class)
    public ResponseEntity<?> validateEmailException(AccountManagementSystemException accountManagementSystemException){
        return new ResponseEntity<>(accountManagementSystemException.getMessage(), accountManagementSystemException.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> catchExceptionsHandler(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
