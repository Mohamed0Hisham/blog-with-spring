package com.ascendant.blog.controllers;

import com.ascendant.blog.domain.dtos.CategoryDto;
import com.ascendant.blog.mappers.CategoryMapper;
import com.ascendant.blog.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.listAllCategories()
                .stream()
                .map(categoryMapper::toCategoryDto)
                .toList();
        return ResponseEntity.ok(categories);
    }
}
