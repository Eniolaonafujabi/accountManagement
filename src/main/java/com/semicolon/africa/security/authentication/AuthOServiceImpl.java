package com.semicolon.africa.security.authentication;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class AuthOServiceImpl implements AuthOServices{

    private SecureRandom otpGenerator = new SecureRandom();
    private StringBuilder otpMorpher = new StringBuilder();

    @Override
    public String generateOTP() {
        String otp = String.valueOf(otpMorpher.append(otpGenerator.nextInt(100_100, 999_999)));
        return otp;
    }
}
