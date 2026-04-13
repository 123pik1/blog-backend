package com.pik.database.repository;

import javax.xml.stream.events.Comment;

import org.hibernate.SessionFactory;

public class CommentRepository extends PostRepository {
    CommentRepository(SessionFactory factory) {
        super(factory, Comment.class);
    }

}
