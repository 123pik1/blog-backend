package com.pik.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentDTO {

    // from post
    private Long id;

    private String author;

    private String content;
    private LocalDateTime creationDate;
    private boolean edited;
    private LocalDateTime lastEditionDate;

    private RatingDTO rating;

    // from comment
    private Long parentPostId;
}
