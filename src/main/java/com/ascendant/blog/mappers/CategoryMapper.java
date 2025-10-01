package com.ascendant.blog.mappers;


import com.ascendant.blog.domain.dtos.CategoryDto;
import com.ascendant.blog.domain.dtos.CreateCategoryRequest;
import com.ascendant.blog.domain.entities.Category;
import com.ascendant.blog.domain.entities.Post;

import java.util.List;

public interface CategoryMapper {

    CategoryDto toCategoryDto(Category category);
    Long calculatePostCount(List<Post> posts);
    Category toCategory(CreateCategoryRequest createCategoryRequest);
}
