package com.pik.database.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pik.database.entities.Article;

public class ArticleRepository extends PostRepository {
    ArticleRepository(SessionFactory factory) {
        super(factory, Article.class);
    }

    public List<Article> findByCategory(String categoryName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Article where category.name = :name", Article.class)
                    .setParameter("name", categoryName)
                    .list();
        }
    }
}
