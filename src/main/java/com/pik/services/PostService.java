package com.pik.services;

import com.pik.database.entities.Post;
import com.pik.database.repository.core.GenericRepository;
import com.pik.services.core.GenericService;

public abstract class PostService<T extends Post, DTO> extends GenericService<T, DTO> {
    PostService(GenericRepository repository) {
        super(repository);
    }
}
