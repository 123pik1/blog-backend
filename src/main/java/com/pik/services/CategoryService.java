package com.pik.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pik.database.entities.Category;
import com.pik.database.repository.CategoryRepository;
import com.pik.dtos.CategoryDTO;
import com.pik.mappers.CategoryMapper;
import com.pik.services.core.GenericService;

@Service
public class CategoryService extends GenericService<Category, CategoryDTO, CategoryMapper> {
    private CategoryRepository categoryRepository;

    CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
        this.categoryRepository = repository;
    }

    // TODO: maybe it is to be changed
    public Category getParentCategory(Long id) {
        return repository.findById(id).get();
    }

    public List<CategoryDTO> getFromSection(Long id) {
        List<Category> categories = categoryRepository.findBySectionId(id);
        return mapper.toDtoList(categories);
    }
}
