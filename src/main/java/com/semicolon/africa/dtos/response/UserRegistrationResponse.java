package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationResponse {
    private Object message;
    private boolean status;
    private Long userId;
}
