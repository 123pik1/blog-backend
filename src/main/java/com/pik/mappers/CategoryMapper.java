package com.pik.mappers;

import org.springframework.stereotype.Component;

import com.pik.database.entities.Category;
import com.pik.dtos.CategoryDTO;
import com.pik.mappers.core.GenericMapper;
import com.pik.services.CategoryService;

@Component
public class CategoryMapper implements GenericMapper<Category, CategoryDTO> {
    private CategoryService categoryService;

    CategoryMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Category toEntity(CategoryDTO dto) {
        Category cat = new Category();
        cat.setId(dto.getId());
        cat.setName(dto.getName());
        cat.setDescription(dto.getDescription());
        if (dto.getParentCategory() == null)
            cat.setParentCategory(null);
        else // TODO: maybe change it
            cat.setParentCategory(categoryService.getParentCategory(dto.getId()));
        return cat;
    }

    public CategoryDTO toDto(Category cat) {
        CategoryDTO dto = new CategoryDTO();
        dto.setParentCategory(cat.getParentCategory().getId());
        dto.setId(cat.getId());
        dto.setDescription(dto.getDescription());
        dto.setName(dto.getName());
        return dto;
    }
}
