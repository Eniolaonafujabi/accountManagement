package com.semicolon.africa.security.authentication;

import com.semicolon.africa.dtos.requests.LogInRequest;
import com.semicolon.africa.dtos.response.LoginValidationResponse;

public interface ValidationServices {
    LoginValidationResponse validateLogInDetails(LogInRequest logInRequest);
}
