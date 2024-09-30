package com.semicolon.africa.utilities;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.models.enums.Industry;
import com.semicolon.africa.data.models.enums.Role;
import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.exception.InvalidEmailException;
import com.semicolon.africa.exception.InvalidNameException;
import com.semicolon.africa.exception.InvalidPasswordException;
import com.semicolon.africa.exception.UserAlreadyExistsException;
import com.semicolon.africa.services.Interfaces.UserServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Component
public class RegistrationDataValidator {

    public static UserRegistrationRequest validateDetails(UserRegistrationRequest userRegistrationRequest){
        String firstNameValidated = validateName(userRegistrationRequest.getFirstName());
        String lastNameValidated = validateName(userRegistrationRequest.getLastName());
        String passwordValidated = validatePassword(userRegistrationRequest.getPassword());
        String emailValidate = validateEmail(userRegistrationRequest.getEmail());
        return mapper(firstNameValidated, lastNameValidated, emailValidate, passwordValidated, userRegistrationRequest.getIndustry(), userRegistrationRequest.getRole());
    }

    private static String validateName(String name){
        if(!Objects.equals(name, "") && !Objects.equals(name, " ")){return name;}
        else{throw new InvalidNameException("Invalid name input");}
    }
    private static String validatePassword(String password){
        if(!password.isEmpty() && !password.equals(" ")){return password;}
        else{throw new InvalidPasswordException("Invalid password.");}
    }
    private static String validateEmail(String email) {
        if(email != null && !email.equals(" ") && email.contains("@")){return email;}
        else{throw new InvalidEmailException("Please enter a valid email.");}
    }

    private static UserRegistrationRequest mapper(String firstName, String lastName, String email, String password, Industry industry, Role role){
        UserRegistrationRequest validateRequestData = new UserRegistrationRequest();
        validateRequestData.setFirstName(firstName);
        validateRequestData.setLastName(lastName);
        validateRequestData.setEmail(email);
        validateRequestData.setPassword(password);
        validateRequestData.setRole(role);
        validateRequestData.setIndustry(industry);
        return validateRequestData;
    }
}
