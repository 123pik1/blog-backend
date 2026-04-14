package com.pik.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostDTO {
    private Long id;
    private String author;
    private String description;
    private LocalDateTime creationDate;
    private boolean edited;
    private LocalDateTime lastEditionDate;
    private RatingDTO rating;
}
