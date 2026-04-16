package com.pik.services;

import com.pik.services.core.GenericService;

import org.springframework.stereotype.Service;

import com.pik.database.entities.User;
import com.pik.database.repository.UserRepository;
import com.pik.dtos.UserDTO;

@Service
public class UserService extends GenericService<User, UserDTO> {
    UserService(UserRepository repository) {
        super(repository);
    }

    protected User mapToEntity(UserDTO dto) {
        return new User();
    }

    protected UserDTO mapToDTO(User entiti) {
        return new UserDTO();
    }
}
