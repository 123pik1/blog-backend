package com.pik.services;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
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
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        System.out.println(articleDto);
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        return save(articleDto);
    }
}
