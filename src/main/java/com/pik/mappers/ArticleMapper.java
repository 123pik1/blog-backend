package com.pik.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pik.database.entities.Article;
import com.pik.database.entities.Category;
import com.pik.database.entities.User;
import com.pik.database.repository.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    public Article toEntity(ArticleDTO dto) {
        Article article = new Article();
        article.setId(dto.getId());
        article.setTags(dto.getTags());
        article.setTitle(dto.getTitle());
        Optional<User> user = userRepository.findByUsername(dto.getAuthor());
        if (user.isPresent())
            article.setAuthor(user.get());
        article.setEdited(dto.getEdited());
        article.setPublic(dto.getIsPublic());
        article.setContent(dto.getContent());
        article.setCategory(categoryRepository.findById(dto.getCategory()).get());
        article.setCreationDate(dto.getCreationDate());
        article.setLastEditionDate(dto.getLastEditDate());
        return article;
    }

    public ArticleDTO toDto(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setCreationDate(article.getCreationDate());
        dto.setCategory(article.getCategory().getId());
        dto.setContent(article.getContent());
        dto.setEdited(article.getEdited());
        if (article.getAuthor() != null)
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
