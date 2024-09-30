package com.semicolon.africa.services.Interfaces;

import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.dtos.response.UserRegistrationResponse;

public interface UserServices {
    UserRegistrationResponse createUserAccount(UserRegistrationRequest userRegistrationRequest);
}
