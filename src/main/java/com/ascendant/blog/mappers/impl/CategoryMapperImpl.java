package com.ascendant.blog.mappers.impl;

import com.ascendant.blog.domain.PostStatus;
import com.ascendant.blog.domain.dtos.CategoryDto;
import com.ascendant.blog.domain.dtos.CreateCategoryRequest;
import com.ascendant.blog.domain.entities.Category;
import com.ascendant.blog.domain.entities.Post;
import com.ascendant.blog.mappers.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toCategoryDto(Category category) {
        if (category == null) {
            return null;
        }

        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .postCount(calculatePostCount(category.getPosts()))
                .build();
    }

    @Override
    public Long calculatePostCount(List<Post> posts) {
        if (posts == null) {
            return 0L;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }

    @Override
    public Category toCategory(CreateCategoryRequest createCategoryRequest) {
        if(createCategoryRequest == null) {
            return null;
        }
        return new Category(createCategoryRequest.getName());
    }
}

