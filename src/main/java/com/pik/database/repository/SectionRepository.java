package com.pik.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pik.database.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
    Section findByName(String name);
}
