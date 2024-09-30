package com.semicolon.africa.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter

public class AccountManagementSystemException extends Exception{

    private HttpStatus status;
    AccountManagementSystemException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
