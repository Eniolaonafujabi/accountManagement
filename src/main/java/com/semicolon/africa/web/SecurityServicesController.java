package com.semicolon.africa.web;

import com.semicolon.africa.dtos.requests.LogInRequest;
import com.semicolon.africa.dtos.response.EmailValidationResponse;
import com.semicolon.africa.dtos.response.LoginValidationResponse;
import com.semicolon.africa.security.authentication.AuthOServiceImpl;
import com.semicolon.africa.security.authentication.AuthOServices;
import com.semicolon.africa.security.authentication.ValidationServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SecurityServicesController {

    private final AuthOServices authOServices;
    private final ValidationServices validationServices;

    @PostMapping("/login")
    public ResponseEntity<?> validateLoginDetails(@RequestBody LogInRequest logInRequest){
        LoginValidationResponse loginValidationResponse= validationServices.validateLogInDetails(logInRequest);
        return new ResponseEntity<>(loginValidationResponse.isUserExists(), HttpStatus.ACCEPTED);
    }
}
