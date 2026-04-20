package com.pik.services;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public ArticleDTO createArticle(ArticleDTO articleDto, Authentication authentication) {

        String username = authentication.getName();
        articleDto.setAuthor(username);
        articleDto.setCreationDate(LocalDateTime.now());
        articleDto.setEdited(false);
        articleDto.setId(null);
        System.out.println(articleDto);
        return save(articleDto);
    }

    public ArticleDTO updateArticle(ArticleDTO newArticle) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ArticleDTO existingArticle = findById(newArticle.getId());

        if (existingArticle == null)
            return null;

        if (!existingArticle.getAuthor().equals(username)
                && !authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return null;
        }
        if (newArticle.getTags() != null && !newArticle.getTags().isEmpty())
            existingArticle.setTags(newArticle.getTags());
        if (newArticle.getTitle() != null && !newArticle.getTitle().isEmpty())
            existingArticle.setTitle(newArticle.getTitle());
        if (newArticle.getContent() != null && !newArticle.getContent().isEmpty())
            existingArticle.setContent(newArticle.getContent());
        if (newArticle.getCategory() != null)
            existingArticle.setCategory(newArticle.getCategory());
        existingArticle.setEdited(true);
        existingArticle.setLastEditDate(LocalDateTime.now());
        return save(existingArticle);
    }
}
