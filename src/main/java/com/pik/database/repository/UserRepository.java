package com.pik.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pik.database.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
