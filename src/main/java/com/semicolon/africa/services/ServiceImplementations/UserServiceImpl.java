package com.semicolon.africa.services.ServiceImplementations;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.dtos.response.UserRegistrationResponse;
import com.semicolon.africa.exception.UserAlreadyExistsException;
import com.semicolon.africa.services.Interfaces.UserServices;
import com.semicolon.africa.utilities.Mapper;
import com.semicolon.africa.utilities.RegistrationDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        checkIfEmailExists(mappedUser.getEmail());
        User savedUser = userRepository.save(mappedUser);
        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        userRegistrationResponse.setMessage("Account created successfully.");
        userRegistrationResponse.setStatus(true);
        userRegistrationResponse.setUserId(savedUser.getId());
        return userRegistrationResponse;
    }

    @Override
    public boolean findUser(String email, String password){
        for(User user : userRepository.findAll()){
            if (user.getEmail().equalsIgnoreCase(email)  && user.getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        throw new UsernameNotFoundException("User not found.");
    }

    @Override
    public Optional<User> findUserBy(String email) {
        for(User user : userRepository.findAll()){
            if(user.getEmail().equals(email)){
                return Optional.of(user);
            }
        }
        return null;
    }
    private void checkIfEmailExists(String email){
        User user =  userRepository.findByEmail(email);
        if(user == null){
            return;
        }
        throw new UserAlreadyExistsException("User already exists.");
    }

}
