package com.pik.mappers;

import org.springframework.stereotype.Component;

import com.pik.database.entities.Section;
import com.pik.dtos.SectionDTO;
import com.pik.mappers.core.GenericMapper;

@Component
public class SectionMapper implements GenericMapper<Section, SectionDTO> {
    public Section toEntity(SectionDTO dto) {
        Section section = new Section();
        section.setId(dto.getId());
        section.setName(dto.getName());
        section.setDescription(dto.getDescription());
        return section;
    }

    public SectionDTO toDto(Section section) {
        SectionDTO dto = new SectionDTO();
        dto.setDescription(section.getDescription());
        dto.setName(section.getName());
        dto.setId(section.getId());
        return dto;
    }
}
