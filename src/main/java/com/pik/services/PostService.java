package com.pik.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.pik.database.entities.Post;
import com.pik.services.core.GenericService;

@Service
public abstract class PostService<T extends Post, DTO> extends GenericService<T, DTO> {
    PostService(JpaRepository<T, Long> repository) {
        super(repository);
    }

}
