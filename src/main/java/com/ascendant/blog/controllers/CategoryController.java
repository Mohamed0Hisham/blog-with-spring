package com.ascendant.blog.controllers;

import com.ascendant.blog.domain.dtos.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return null;
    }
}
