package com.example.jwtdemo.dto;

public class JwtResponse {

    private String token;
    private String tokenType;
    private long expiresIn;

    public JwtResponse(String token, long expiresIn) {
        this.token = token;
        this.tokenType = "Bearer";
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public long getExpiresIn() {
        return expiresIn;
    }
}