package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import javax.mail.Session;
import java.util.Date;

@Getter
@Setter
public class SendEmailRequest {
    private String senderEmailAddress;
    private String recipientEmailAddress;
    private String subject;
    private Date sentDate;
    private String body;
    private Session session;
    private String authPassword;
}
