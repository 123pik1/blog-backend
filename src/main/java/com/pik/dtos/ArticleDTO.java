package com.pik.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ArticleDTO {
    private Long id; //
    private String author; //
    private String content; //
    private LocalDateTime creationDate; //
    private RatingDTO rating; //
    private Boolean edited; //
    private LocalDateTime lastEditDate; //
    private List<CommentDTO> comments; //
    private String title;//
    private List<String> tags; //
    private CategoryDTO category;//
    private Boolean isPublic;
}
