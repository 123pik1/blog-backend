package com.pik.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pik.database.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
