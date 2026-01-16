package com.auth_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.dto.AuthResponse;
import com.auth_service.dto.LoginRequest;
import com.auth_service.dto.RegisterRequest;
import com.auth_service.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
	 private final AuthService authService;

	    @PostMapping("/register")
	    public void register(@Valid @RequestBody RegisterRequest request) {
	        authService.register(request);
	    }

	    @PostMapping("/login")
	    public AuthResponse login(@RequestBody LoginRequest request) {
	        return authService.login(request);
	    }
}
