package com.pik.mappers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.pik.database.entities.Category;
import com.pik.database.entities.Section;
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
        if (dto == null)
            return new Category();
        Category cat = new Category();
        cat.setId(dto.getId());
        cat.setName(dto.getName());
        cat.setDescription(dto.getDescription());
        Optional<Section> section = sectionRepository.findById(dto.getSectionId());
        if (section.isPresent())
            cat.setSection(section.get());
        return cat;
    }

    public CategoryDTO toDto(Category cat) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(cat.getId());
        dto.setDescription(cat.getDescription());
        dto.setName(cat.getName());
        if (cat.getSection() != null)
            dto.setSectionId(cat.getSection().getId());
        return dto;
    }
}
