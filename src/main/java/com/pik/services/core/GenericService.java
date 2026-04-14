package com.pik.services.core;

import com.pik.database.repository.core.GenericRepository;

public abstract class GenericService<T, DTO> {
    protected final GenericRepository<T> repository;

    protected GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public void save(T entity) {
        repository.save(entity);
    }

    public DTO findById(Long id) {
        T entity = repository.findById(id);
        if (entity == null)
            return null;
        return mapToDTO(entity);
    }

    protected abstract T mapToEntity(DTO dto);

    protected abstract DTO mapToDTO(T entity);
}
