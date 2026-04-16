package com.pik.services;

import org.springframework.stereotype.Service;

import com.pik.database.entities.Comment;
import com.pik.database.repository.CommentRepository;
import com.pik.dtos.CommentDTO;
import com.pik.mappers.CommentMapper;

@Service
public class CommentService extends PostService<Comment, CommentDTO, CommentMapper> {
    CommentService(CommentRepository repository, CommentMapper mapper) {
        super(repository, mapper);
    }

}
