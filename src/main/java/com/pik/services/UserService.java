package com.pik.services;

import com.pik.services.core.GenericService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.pik.database.entities.User;
import com.pik.database.repository.UserRepository;
import com.pik.dtos.UserDTO;
import com.pik.mappers.UserMapper;

@Service
public class UserService extends GenericService<User, UserDTO, UserMapper> {
    private final UserRepository userRepository;

    UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
        userRepository = repository;
    }

    public UserDTO findByUsername(String username) {
        User entity = userRepository.findByUsername(username).orElse(null);
        if (entity == null)
            return null;
        return mapToDTO(entity);
    }

    public UserDTO getMe() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDTO dto = findByUsername(username);
        return dto;
    }

}
