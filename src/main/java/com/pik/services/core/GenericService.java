package com.pik.services.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<T, DTO> {
    protected final JpaRepository<T, Long> repository;

    protected GenericService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    protected T saveEntity(T entity) {
        return repository.save(entity);
    }

    public DTO save(DTO dto) {
        return mapToDTO(saveEntity(mapToEntity(dto)));
    }

    public List<DTO> getAll() {

        List<DTO> dtos = new ArrayList<DTO>();
        List<T> entities = repository.findAll();

        for (T entity : entities) {
            dtos.add(mapToDTO(entity));
        }

        return dtos;
    }

    public DTO findById(Long id) {
        T entity = repository.findById(id).orElse(null);
        if (entity == null)
            return null;
        return mapToDTO(entity);
    }

    protected abstract T mapToEntity(DTO dto);

    protected abstract DTO mapToDTO(T entity);
}
