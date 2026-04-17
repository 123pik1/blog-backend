package com.pik.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private Boolean canBlog;
    private String description;
    private String role;
    private LocalDateTime createdAt;
}
