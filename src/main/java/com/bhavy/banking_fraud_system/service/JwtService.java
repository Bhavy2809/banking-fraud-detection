package com.bhavy.banking_fraud_system.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import com.bhavy.banking_fraud_system.entity.User;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "mySuperSecretKeyForBankingFraudSystemProject123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String generateToken(User user) {

        return Jwts.builder()
                .subject(user.getEmail())
                .claim("role", user.getRole().name())
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60 * 24
                        )
                )
                .signWith(getSignInKey())
                .compact();
    }

    private SecretKey getSignInKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }

    public String extractUsername(String token) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(getSignInKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.getSubject();
    }
    public String extractRole(String token) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(getSignInKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.get("role", String.class);
    }
    public boolean isTokenValid(String token) {

        try {

            Jwts.parser()
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}