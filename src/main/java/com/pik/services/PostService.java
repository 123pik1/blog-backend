package com.pik.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.pik.database.entities.Post;
import com.pik.services.core.GenericService;
import com.pik.mappers.core.GenericMapper;

@Service
public abstract class PostService<T extends Post, DTO, MAPPER extends GenericMapper<T, DTO>>
        extends GenericService<T, DTO, MAPPER> {

    PostService(JpaRepository<T, Long> repository, MAPPER mapper) {
        super(repository, mapper);
    }

}
