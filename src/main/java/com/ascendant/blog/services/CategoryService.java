package com.ascendant.blog.services;

import com.ascendant.blog.domain.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> listAllCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID id);
}
