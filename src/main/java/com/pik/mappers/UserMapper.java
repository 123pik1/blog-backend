package com.pik.mappers;

import org.springframework.stereotype.Component;

import com.pik.database.entities.User;
import com.pik.dtos.UserDTO;
import com.pik.mappers.core.GenericMapper;

@Component
public class UserMapper implements GenericMapper<User, UserDTO> {

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setCanBlog(dto.getCanBlog());
        user.setUsername(dto.getUsername());
        user.setDescription(dto.getDescription());
        user.setRole(dto.getRole());
        // Password in other place
        return user;
    }

    public UserDTO toDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setDescription(entity.getDescription());
        dto.setUsername(entity.getUsername());
        dto.setCanBlog(entity.getCanBlog());
        dto.setId(entity.getId());
        dto.setRole(entity.getRole());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

}
