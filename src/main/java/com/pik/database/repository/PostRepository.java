package com.pik.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.pik.database.entities.Post;

@NoRepositoryBean
public interface PostRepository<T extends Post> extends JpaRepository<T, Long> {

}
