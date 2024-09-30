package com.semicolon.africa.web;

import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.dtos.response.UserRegistrationResponse;
import com.semicolon.africa.services.Interfaces.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServices userService;

    @PostMapping("/user/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        try{
            UserRegistrationResponse registrationResponse = userService.createUserAccount(userRegistrationRequest);
            return new ResponseEntity<>(registrationResponse.getMessage(), HttpStatus.CREATED);
        }catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.CREATED);
        }
    }
}
