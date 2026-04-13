package com.pik.database.repository;

import org.hibernate.SessionFactory;

import com.pik.database.entities.Photo;
import com.pik.database.entities.Post;
import com.pik.database.repository.core.GenericRepository;

public class PostRepository extends GenericRepository<Post> {
    public PostRepository(SessionFactory factory, Class<?> clazz) {
        super(factory, (Class<Post>) clazz);
    }

    public PostRepository(SessionFactory factory) {
        super(factory, Post.class);
    }

}
