package com.semicolon.africa.services.Interfaces;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.dtos.response.UserRegistrationResponse;

import java.util.Optional;

public interface UserServices {
    UserRegistrationResponse createUserAccount(UserRegistrationRequest userRegistrationRequest);

    boolean findUser(String email, String password);

    Optional<User> findUserBy(String email);
}
