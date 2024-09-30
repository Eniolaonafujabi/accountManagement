package com.semicolon.africa.security.authentication;

import com.semicolon.africa.dtos.requests.LogInRequest;
import com.semicolon.africa.dtos.response.LoginValidationResponse;
import com.semicolon.africa.services.Interfaces.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateLogIn implements ValidationServices {

    private final UserServices userServices;

    public LoginValidationResponse validateLogInDetails(LogInRequest logInRequest){
         boolean userExists = userServices.findUser(logInRequest.getEmail(), logInRequest.getPassword());
         LoginValidationResponse loginValidationResponse = new LoginValidationResponse();
         loginValidationResponse.setUserExists(userExists);
         return loginValidationResponse;
    }
}
