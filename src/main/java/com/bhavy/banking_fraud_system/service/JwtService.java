package com.bhavy.banking_fraud_system.service;

import io.jsonwebtoken.Jwts;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60 * 24
                        )
                )
                .signWith(
                        io.jsonwebtoken.security.Keys.hmacShaKeyFor(
                                SECRET_KEY.getBytes()
                        )
                )
                .compact();
    }
    private static final String SECRET_KEY =
            "mySuperSecretKeyForBankingFraudSystemProject123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

}