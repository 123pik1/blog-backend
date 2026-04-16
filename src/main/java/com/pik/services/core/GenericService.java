package com.pik.services.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pik.mappers.core.GenericMapper;

public abstract class GenericService<T, DTO, MAPPER extends GenericMapper<T, DTO>> {
    protected final JpaRepository<T, Long> repository;
    protected final MAPPER mapper;

    protected GenericService(JpaRepository<T, Long> repository, MAPPER mapper) {
        this.repository = repository;
        this.mapper = mapper;
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

    protected T mapToEntity(DTO dto) {
        return mapper.toEntity(dto);
    }

    protected DTO mapToDTO(T entity) {
        return mapper.toDto(entity);
    }
}
