package com.semicolon.africa.web;

import com.semicolon.africa.dtos.requests.LogInRequest;
import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.dtos.response.UserRegistrationResponse;
import com.semicolon.africa.services.Interfaces.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {


    private final UserServices userService;
    private final SecurityServicesController securityServicesController;

    @PostMapping("/user/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        try{
            UserRegistrationResponse registrationResponse = userService.createUserAccount(userRegistrationRequest);
            return new ResponseEntity<>(registrationResponse.getMessage(), HttpStatus.CREATED);
        }catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.CREATED);
        }
    }
    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody LogInRequest logInRequest){
        return securityServicesController.validateLoginDetails(logInRequest);
    }
}
