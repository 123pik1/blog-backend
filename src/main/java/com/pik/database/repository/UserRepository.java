package com.pik.database.repository;

import org.hibernate.SessionFactory;

import com.pik.database.entities.User;
import com.pik.database.repository.core.GenericRepository;

public class UserRepository extends GenericRepository<User> {
    public UserRepository(SessionFactory factory) {
        super(factory, User.class);
    }

}
