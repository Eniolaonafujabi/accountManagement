package com.semicolon.africa.secuitryTests;

import com.semicolon.africa.security.authentication.AuthOServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GenerateOTPTest {
    @Test
    void testThatOTPCanBeGenerated(){
        AuthOServiceImpl authenticator = new AuthOServiceImpl();
        String otp = authenticator.generateOTP();
        System.out.println(otp);
        assertThat(otp.length()).isEqualTo(6);
    }
    @Test
    void testThat2_OTPsGenerated_AreNotTheSame(){
        AuthOServiceImpl authenticator = new AuthOServiceImpl();
        AuthOServiceImpl authenticator2 = new AuthOServiceImpl();
        String otp = authenticator.generateOTP();
        String otp2 = authenticator2.generateOTP();
        System.out.println(otp);
        System.out.println(otp2);
        assertThat(otp).isNotEqualTo(otp2);
    }
}