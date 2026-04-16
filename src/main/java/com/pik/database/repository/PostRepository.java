package com.pik.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.pik.database.entities.Post;

//@NoRepositoryBean
@Repository
public interface PostRepository<T extends Post> extends JpaRepository<T, Long> {

}
