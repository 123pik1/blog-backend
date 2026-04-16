package com.pik.dtos;

import lombok.Data;

@Data
public class PhotoDTO {
    private String localistion;
    private String description;
    private Long id;
    private Long postId;
}
