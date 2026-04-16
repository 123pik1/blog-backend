package com.pik.mappers.core;

import java.util.ArrayList;
import java.util.List;

/*
 * E = Entity
 * D = DTO
 */
public interface GenericMapper<E, D> {
    D toDto(E entity);

    E toEntity(D dto);

    default List<D> toDtoList(List<E> entities) {
        if (entities == null)
            return null;
        List<D> dtos = new ArrayList<D>();
        for (E entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    default List<E> toEntityList(List<D> dtos) {
        if (dtos == null)
            return null;
        List<E> entites = new ArrayList<E>();
        for (D dto : dtos) {
            entites.add(toEntity(dto));
        }
        return entites;
    }

}
