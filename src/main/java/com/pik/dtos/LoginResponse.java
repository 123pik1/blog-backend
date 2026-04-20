package com.pik.dtos;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String username;
}
