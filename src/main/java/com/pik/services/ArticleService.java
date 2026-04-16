package com.pik.services;

import org.springframework.stereotype.Service;

import com.pik.database.entities.Article;
import com.pik.database.repository.ArticleRepository;
import com.pik.dtos.ArticleDTO;
import com.pik.mappers.ArticleMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArticleService extends PostService<Article, ArticleDTO, ArticleMapper> {
    ArticleService(ArticleRepository repository, ArticleMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected Article mapToEntity(ArticleDTO dto) {
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setTags(dto.getTags());
        // article.setCategory(dto.getCategory());
        article.setId(dto.getId());
        // article.setAuthor(dto.getAuthor());
        article.setEdited(dto.getEdited());
        return new Article();
    }

    @Override
    protected ArticleDTO mapToDTO(Article entity) {

        return new ArticleDTO();
    }
}
