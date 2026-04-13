package com.pik.database.repository;

import org.hibernate.SessionFactory;

import com.pik.database.entities.Category;
import com.pik.database.repository.core.GenericRepository;

public class CategoryRepository extends GenericRepository<Category> {
    CategoryRepository(SessionFactory factory) {
        super(factory, Category.class);
    }

}
