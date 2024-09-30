package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInRequest {
    private String email;
    private String password;
    private boolean emailExists;
    private boolean passwordExists;
}
