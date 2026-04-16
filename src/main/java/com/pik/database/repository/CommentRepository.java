package com.pik.database.repository;

import org.springframework.stereotype.Repository;

import com.pik.database.entities.Comment;

@Repository
public interface CommentRepository extends PostRepository<Comment> {
}
