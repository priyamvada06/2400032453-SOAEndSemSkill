package com.example.jwtdemo.config;

import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(
            secret.getBytes(java.nio.charset.StandardCharsets.UTF_8)
        );
    }
}