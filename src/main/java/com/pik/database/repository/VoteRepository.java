package com.pik.database.repository;

import org.hibernate.SessionFactory;

import com.pik.database.entities.Vote;
import com.pik.database.repository.core.GenericRepository;

public class VoteRepository extends GenericRepository<Vote> {
    VoteRepository(SessionFactory factory) {
        super(factory, Vote.class);
    }

}
