package com.pik.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pik.dtos.CategoryDTO;
import com.pik.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAll());
    }

    @GetMapping("/{sectionId}/categories")
    public ResponseEntity<List<CategoryDTO>> getAllFromCategory(@PathVariable Long sectionId) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getFromSection(sectionId));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryDTO));
    }
}
