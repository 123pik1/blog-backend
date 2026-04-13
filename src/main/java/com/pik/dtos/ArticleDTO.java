package com.pik.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticleDTO {

    private long id;
    private String author;
    private String content;
    private LocalDateTime creationDate;
    private int upvotes;
    private int downvotes;
}
