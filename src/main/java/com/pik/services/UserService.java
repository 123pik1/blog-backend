package com.pik.services;

import com.pik.services.core.GenericService;

import org.springframework.stereotype.Service;

import com.pik.database.entities.User;
import com.pik.database.repository.UserRepository;
import com.pik.dtos.UserDTO;
import com.pik.mappers.UserMapper;

@Service
public class UserService extends GenericService<User, UserDTO, UserMapper> {
    UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    public UserDTO findByUsername(String username) {
        User entity = repository.findByUsername(username);
        if (entity == null)
            return null;
        return mapToDTO(entity);
    }

}
