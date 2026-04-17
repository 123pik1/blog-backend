package com.pik.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pik.database.entities.Article;
import com.pik.database.repository.UserRepository;
import com.pik.dtos.ArticleDTO;
import com.pik.mappers.core.GenericMapper;
import com.pik.services.RatingService;

@Component
public class ArticleMapper implements GenericMapper<Article, ArticleDTO> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RatingService ratingService;

    public Article toEntity(ArticleDTO dto) {
        Article article = new Article();
        article.setId(dto.getId());
        article.setTags(dto.getTags());
        article.setTitle(dto.getTitle());
        article.setAuthor(userRepository.findByUsername(dto.getAuthor()).get());
        article.setEdited(dto.getEdited());
        article.setPublic(dto.getIsPublic());
        article.setContent(dto.getContent());
        article.setCategory(categoryMapper.toEntity(dto.getCategory()));
        article.setCreationDate(dto.getCreationDate());
        article.setLastEditionDate(dto.getLastEditDate());
        return article;
    }

    public ArticleDTO toDto(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setCreationDate(article.getCreationDate());
        dto.setCategory(categoryMapper.toDto(article.getCategory()));
        dto.setContent(article.getContent());
        dto.setEdited(article.getEdited());
        dto.setAuthor(article.getAuthor().getUsername());
        dto.setTitle(article.getTitle());
        dto.setTags(article.getTags());
        dto.setId(article.getId());
        dto.setRating(ratingService.calculateRatingForPost(article.getId()));
        dto.setIsPublic(article.isPublic());
        dto.setLastEditDate(article.getLastEditionDate());
        return dto;
    }
}
