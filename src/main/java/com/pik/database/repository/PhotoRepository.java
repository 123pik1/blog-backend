package com.pik.database.repository;

import org.hibernate.SessionFactory;

import com.pik.database.entities.Photo;
import com.pik.database.repository.core.GenericRepository;

public class PhotoRepository extends GenericRepository<Photo> {
    PhotoRepository(SessionFactory factory) {
        super(factory, Photo.class);
    }
}
