package com.pik.mappers;

import org.springframework.stereotype.Component;

import com.pik.database.entities.Article;
import com.pik.dtos.ArticleDTO;
import com.pik.mappers.core.GenericMapper;

@Component
public class ArticleMapper implements GenericMapper<Article, ArticleDTO> {
    public Article toEntity(ArticleDTO dto) {
        Article article = new Article();
        return article;
    }

    public ArticleDTO toDto(Article article) {
        ArticleDTO dto = new ArticleDTO();
        return dto;
    }
}
