package com.pik.services;

import org.springframework.stereotype.Service;

import com.pik.database.entities.Section;
import com.pik.database.repository.SectionRepository;
import com.pik.dtos.SectionDTO;
import com.pik.mappers.SectionMapper;
import com.pik.services.core.GenericService;

@Service
public class SectionService extends GenericService<Section, SectionDTO, SectionMapper> {

    SectionService(SectionRepository repository, SectionMapper mapper) {
        super(repository, mapper);
    }
}
