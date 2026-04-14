package com.pik.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ArticleDTO {

    // from Post
    private long id;
    private String author;
    private String content;
    private LocalDateTime creationDate;

    private RatingDTO rating;

    private boolean edited;
    private LocalDateTime lastEditDate;

    private List<CommentDTO> comments;

    // From Article
    private String title;

    private List<String> tags;

    private CategoryDTO category;
}
