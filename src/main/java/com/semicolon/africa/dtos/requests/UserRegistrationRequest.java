package com.semicolon.africa.dtos.requests;

import com.semicolon.africa.data.models.enums.Industry;
import com.semicolon.africa.data.models.enums.Role;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Industry industry;
    private Role role;

}
