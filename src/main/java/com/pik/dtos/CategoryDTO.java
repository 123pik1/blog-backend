package com.pik.dtos;

import com.pik.database.entities.Section;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    // private String sectionName;
    private Long sectionId;
}
