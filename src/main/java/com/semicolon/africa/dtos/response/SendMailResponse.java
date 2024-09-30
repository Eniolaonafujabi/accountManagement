package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMailResponse {
    private Object message;
    private boolean status;
}
