package com.example.jwtdemo.service;

import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JwtService {

    private final SecretKey secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public JwtService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(Map<String, Object> payload) {

        long currentTime = System.currentTimeMillis();

        return Jwts.builder()
                .claims(payload)
                .issuedAt(new Date(currentTime))
                .expiration(new Date(currentTime + expiration))
                .signWith(secretKey)
                .compact();
    }
}