package com.semicolon.africa.services.ServiceImplementations;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.dtos.response.UserRegistrationResponse;
import com.semicolon.africa.services.Interfaces.UserServices;
import com.semicolon.africa.utilities.Mapper;
import com.semicolon.africa.utilities.RegistrationDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegistrationResponse createUserAccount(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        UserRegistrationRequest validateRequest = RegistrationDataValidator.validateDetails(userRegistrationRequest);
        Mapper mapper = new Mapper();
        User mappedUser = mapper.map(validateRequest, user);
        User savedUser = userRepository.save(mappedUser);
        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        userRegistrationResponse.setMessage("Account created successfully.");
        userRegistrationResponse.setStatus(true);
        userRegistrationResponse.setUserId(savedUser.getId());
        return userRegistrationResponse;
    }


}
