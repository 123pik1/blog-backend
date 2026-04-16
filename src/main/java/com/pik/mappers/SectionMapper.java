package com.pik.mappers;

import com.pik.database.entities.Section;
import com.pik.dtos.SectionDTO;
import com.pik.mappers.core.GenericMapper;

public class SectionMapper implements GenericMapper<Section, SectionDTO> {
    public Section toEntity(SectionDTO dto) {
        Section section = new Section();

        return section;
    }

    public SectionDTO toDto(Section section) {
        SectionDTO dto = new SectionDTO();

        return dto;
    }
}
