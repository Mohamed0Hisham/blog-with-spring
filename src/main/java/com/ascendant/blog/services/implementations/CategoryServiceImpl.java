package com.ascendant.blog.services.implementations;

import com.ascendant.blog.domain.entities.Category;
import com.ascendant.blog.repositories.CategoryRepository;
import com.ascendant.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}
