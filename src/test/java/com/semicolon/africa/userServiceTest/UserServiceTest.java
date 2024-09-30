package com.semicolon.africa.userServiceTest;

import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requests.UserRegistrationRequest;
import com.semicolon.africa.dtos.response.UserRegistrationResponse;
import com.semicolon.africa.exception.InvalidPasswordException;
import com.semicolon.africa.services.Interfaces.UserServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.semicolon.africa.data.models.enums.Industry.AGRICULTURE;
import static com.semicolon.africa.data.models.enums.Role.USER;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepositories;

    @BeforeEach
    void setUp() {
        userRepositories.deleteAll();
    }

    @Test
    public void testUserRegistration(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setFirstName("David");
        userRegistrationRequest.setLastName("Odo");
        userRegistrationRequest.setEmail("davidodojunior@gmail.com");
        userRegistrationRequest.setIndustry(AGRICULTURE);
        userRegistrationRequest.setRole(USER);
        userRegistrationRequest.setPassword("123");

        UserRegistrationResponse userRegistrationResponse = userServices.createUserAccount(userRegistrationRequest);
        assertTrue(userRegistrationResponse.isStatus());
    }
    @Test
    void testThatExceptionIsThrownIfEmailIsInvalid(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setFirstName("David");
        userRegistrationRequest.setLastName("Odo");
        userRegistrationRequest.setEmail(" ");
        userRegistrationRequest.setIndustry(AGRICULTURE);
        userRegistrationRequest.setRole(USER);
        userRegistrationRequest.setPassword("123456789");

        assertThrows(InvalidPasswordException.class, () -> {
            userServices.createUserAccount(userRegistrationRequest);  // This should throw the exception
        });
    }
}
