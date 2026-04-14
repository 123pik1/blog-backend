package com.pik.services;

import com.pik.database.entities.Article;
import com.pik.database.repository.ArticleRepository;
import com.pik.dtos.ArticleDTO;

public class ArticleService extends PostService<Article, ArticleDTO> {
    ArticleService(ArticleRepository repository) {
        super(repository);
    }

    @Override
    protected Article mapToEntity(ArticleDTO dto) {
        return new Article();
    }

    @Override
    protected ArticleDTO mapToDTO(Article entity) {
        return new ArticleDTO();
    }
}
