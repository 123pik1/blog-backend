package com.pik.dtos;

import lombok.Data;

@Data
public class CategoryDTO {

    private String name;
    private String description;
    private Long privateParentCategory;
}
