package com.pik.services;

import com.pik.database.entities.Comment;
import com.pik.database.repository.CommentRepository;
import com.pik.dtos.CommentDTO;

public class CommentService extends PostService<Comment, CommentDTO> {
    CommentService(CommentRepository repository) {
        super(repository);
    }

    @Override
    protected CommentDTO mapToDTO(Comment entity) {
        return new CommentDTO();
    }

    @Override
    protected Comment mapToEntity(CommentDTO dto) {
        return new Comment();
    }
}
