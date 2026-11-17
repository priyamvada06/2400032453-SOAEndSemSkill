package com.example.jwtdemo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jwtdemo.dto.JwtRequest;
import com.example.jwtdemo.dto.JwtResponse;
import com.example.jwtdemo.service.JwtService;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/generate")
    public ResponseEntity<JwtResponse> generateToken(
            @RequestBody JwtRequest request) {

        Map<String, Object> payload = request.getPayload();

        if (payload == null || payload.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        String token = jwtService.generateToken(payload);

        return ResponseEntity.ok(
            new JwtResponse(token, 3600)
        );
    }
}