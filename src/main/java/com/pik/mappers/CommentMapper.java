package com.pik.mappers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pik.database.entities.Comment;
import com.pik.database.entities.Post;
import com.pik.database.repository.PostRepository;
import com.pik.dtos.CommentDTO;
import com.pik.mappers.core.GenericMapper;
import com.pik.services.RatingService;
import com.pik.services.UserService;

@Component
public class CommentMapper implements GenericMapper<Comment, CommentDTO> {

    private UserService userService;
    private UserMapper userMapper;
    private PostRepository postRepository;
    private RatingService ratingService;

    CommentMapper(UserService userService, UserMapper userMapper,
            @Qualifier("postRepository") PostRepository postRepository,
            RatingService ratingService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.postRepository = postRepository;
        this.ratingService = ratingService;
    }

    public Comment toEntity(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setAuthor(userMapper.toEntity(userService.findByUsername(dto.getAuthor())));
        comment.setEdited(dto.getEdited());
        comment.setContent(dto.getContent());
        comment.setParentPost((Post) this.postRepository.getReferenceById(dto.getParentPostId()));
        comment.setCreationDate(dto.getCreationDate());
        comment.setLastEditionDate(dto.getLastEditionDate());

        return comment;
    }

    public CommentDTO toDto(Comment entity) {
        CommentDTO dto = new CommentDTO();
        dto.setContent(entity.getContent());
        dto.setEdited(entity.getEdited());
        dto.setAuthor(entity.getAuthor().getUsername());
        dto.setCreationDate(entity.getCreationDate());
        dto.setLastEditionDate(entity.getLastEditionDate());
        dto.setParentPostId(entity.getParentPost().getId());
        dto.setRating(ratingService.calculateRatingForPost(entity.getId()));
        dto.setId(entity.getId());
        return dto;
    }
}
