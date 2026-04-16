package com.pik.database.repository;

import org.springframework.stereotype.Repository;

import com.pik.database.entities.Article;

@Repository
public interface ArticleRepository extends PostRepository<Article> {

}
