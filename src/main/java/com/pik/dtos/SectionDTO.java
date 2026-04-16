package com.pik.dtos;

import java.util.List;

import lombok.Data;

@Data
public class SectionDTO {
    private Long id;
    private String name;
    private String description;
    List<CategoryDTO> categories;
}
