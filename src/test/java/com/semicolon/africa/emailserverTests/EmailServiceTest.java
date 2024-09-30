package com.semicolon.africa.emailserverTests;

import com.semicolon.africa.dtos.requests.SendEmailRequest;
import com.semicolon.africa.dtos.response.SendMailResponse;
import com.semicolon.africa.emailServer.EmailServer;
import com.semicolon.africa.security.authentication.AuthOServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Date;
import java.util.Properties;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:secrets.properties")

class EmailServiceTest {

    @Autowired
    private AuthOServices authenticator;

    @Value("${spring.mail.username}")
    private String email;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.host}")
    private String smtpHost;

    @Value("${spring.mail.port}")
    private String port;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String auth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String startTls;

    @Test
    void testThatEmailServiceCanSendEmailToUser(){
//        Identify requirements; email service should be able to
//        send an email with specified recipients, subjects, and
//        message body using SMTP.

//        Pre-requisite:
//        Given that a user has submitted their email address
//        Given that we have our email sending configuration

        String otp = authenticator.generateOTP();
        String body = "The verification code will be valid for 30 minutes. Please do not share this code with anyone.\n";
        String message = String.format(body + "%s", otp);

        Properties props = new Properties();

        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", startTls);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        SendEmailRequest emailRequest = new SendEmailRequest();
        emailRequest.setSession(session);
        emailRequest.setRecipientEmailAddress("ikemdinachialfred@gmail.com");
        emailRequest.setSubject("Test");
        emailRequest.setBody(message);
        emailRequest.setSentDate(new Date());
        emailRequest.setSenderEmailAddress(email);

//        Action
//        an email can be sent to them.
        EmailServer emailServer = new EmailServer();
        SendMailResponse response = emailServer.sendMail(emailRequest);

//        Assert
        assertThat(response.getMessage()).isEqualTo("Mail sent.");

    }
}