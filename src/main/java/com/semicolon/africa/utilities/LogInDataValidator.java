package com.semicolon.africa.utilities;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requests.LogInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogInDataValidator {
    @Autowired
    private static UserRepository userRepository;

    public static LogInRequest validDetails(LogInRequest logInRequest){

        return null;
    }
    private static String validateEmail(String email){
        for(User user : userRepository.findAll()){
            if(user.getEmail().equalsIgnoreCase(email)){;}
        }
        return null;
    }
}
