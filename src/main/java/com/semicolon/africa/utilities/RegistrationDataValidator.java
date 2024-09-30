package com.semicolon.africa.utilities;

import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.exception.InvalidNameException;
import com.semicolon.africa.exception.InvalidPasswordException;

import java.util.Objects;

public class RegistrationDataValidator {

    public static UserRegistrationRequest validateDetails(UserRegistrationRequest userRegistrationRequest){
        String firstNameValidated = validateName(userRegistrationRequest.getFirstName());
        String lastNameValidated = validateName(userRegistrationRequest.getLastName());
        String passwordValidated = validatePassword(userRegistrationRequest.getPassword());
        String emailValidate = validateEmail(userRegistrationRequest.getEmail());
        return mapper(firstNameValidated, lastNameValidated, passwordValidated, emailValidate);
    }

    private static String validateName(String name){
        if(!Objects.equals(name, "") && !Objects.equals(name, " ")){return name;}
        else{throw new InvalidNameException("Invalid name input");}
    }
    private static String validatePassword(String password){
        if(!Objects.equals(password, "") && !Objects.equals(password, " ") && password.length() != 8){return password;}
        else{throw new InvalidPasswordException("Invalid password.");}
    }
    private static String validateEmail(String email) {
        if(!Objects.equals(email, "") && !Objects.equals(email, " ") && email.contains("@")){return email;}
        else{throw new InvalidPasswordException("Please enter a valid email.");}
    }
    private static UserRegistrationRequest mapper(String firstName, String lastName, String email, String password){
        UserRegistrationRequest validateRequestData = new UserRegistrationRequest();
        validateRequestData.setFirstName(firstName);
        validateRequestData.setLastName(lastName);
        validateRequestData.setEmail(email);
        validateRequestData.setPassword(password);
        return validateRequestData;
    }
}
