package com.pik.services;

import java.util.Optional;

import com.pik.database.entities.Category;
import com.pik.database.repository.CategoryRepository;
import com.pik.dtos.CategoryDTO;
import com.pik.services.core.GenericService;

public class CategoryService extends GenericService<Category, CategoryDTO> {
    CategoryService(CategoryRepository repository) {
        super(repository);
    }

    public Category mapToEntity(CategoryDTO dto) {
        return new Category();
    }

    public CategoryDTO mapToDTO(Category cat) {
        return new CategoryDTO();
    }

    // TODO: maybe it is to be changed
    public Category getParentCategory(Long id) {
        return repository.findById(id).get();
    }
}
