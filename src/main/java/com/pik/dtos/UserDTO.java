package com.pik.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private Boolean canBlog;
    private String description;
    private String role;
}
