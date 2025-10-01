package com.ascendant.blog.services;

import com.ascendant.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listAllCategories();
    Category createCategory(Category category);
}
