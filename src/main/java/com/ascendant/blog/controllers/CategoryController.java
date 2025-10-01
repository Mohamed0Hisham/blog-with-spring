package com.ascendant.blog.controllers;

import com.ascendant.blog.domain.dtos.CategoryDto;
import com.ascendant.blog.domain.dtos.CreateCategoryRequest;
import com.ascendant.blog.domain.entities.Category;
import com.ascendant.blog.mappers.CategoryMapper;
import com.ascendant.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        Category categoryToCreate = categoryMapper.toCategory(createCategoryRequest);

        Category savedCategory =  categoryService.createCategory(categoryToCreate);
        return new ResponseEntity<>(
                categoryMapper.toCategoryDto(savedCategory),
                HttpStatus.CREATED
        );
    }
}
