package com.pik.database.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pik.database.entities.Vote;
import com.pik.database.repository.core.GenericRepository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByPostId(Long id);
}
