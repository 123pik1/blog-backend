package com.pik.services;

import com.pik.services.core.GenericService;

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
        User entity = userRepository.findByUsername(username).get();
        if (entity == null)
            return null;
        return mapToDTO(entity);
    }

}
