package com.pik.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pik.dtos.LoginDTO;
import com.pik.dtos.LoginResponse;
import com.pik.dtos.RegisterDTO;
import com.pik.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private AuthService authService;

    AuthenticationController(AuthService authService) {
        this.authService = authService;

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO loginRequest) {
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterDTO registerDTO) {
        LoginResponse response = authService.register(registerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
