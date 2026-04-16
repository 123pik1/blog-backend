package com.pik.controllers;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pik.dtos.ArticleDTO;
import com.pik.services.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticle(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO dto) {
        ArticleDTO createdArticle = articleService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
    }
}
