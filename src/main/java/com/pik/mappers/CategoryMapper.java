package com.pik.mappers;

import org.springframework.stereotype.Component;

import com.pik.database.entities.Category;
import com.pik.database.repository.SectionRepository;
import com.pik.dtos.CategoryDTO;
import com.pik.mappers.core.GenericMapper;

@Component
public class CategoryMapper implements GenericMapper<Category, CategoryDTO> {

    private SectionRepository sectionRepository;

    CategoryMapper(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Category toEntity(CategoryDTO dto) {
        Category cat = new Category();
        cat.setId(dto.getId());
        cat.setName(dto.getName());
        cat.setDescription(dto.getDescription());
        cat.setSection(sectionRepository.findByName(dto.getSectionName()));
        return cat;
    }

    public CategoryDTO toDto(Category cat) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(cat.getId());
        dto.setDescription(cat.getDescription());
        dto.setName(cat.getName());
        dto.setSectionName(cat.getSection().getName());
        return dto;
    }
}
