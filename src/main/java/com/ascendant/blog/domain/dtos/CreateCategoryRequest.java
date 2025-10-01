package com.ascendant.blog.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateCategoryRequest {

    @NotBlank(message = "Category name is required")
    @Size(
            min = 2,
            max = 50,
            message = "Category name must be between {min}-{max} characters"
    )
    @Pattern(regexp = "^[\\w\\s-]+", message = "Category name can only contain letters, numbers, spaces and hyphens")
    private  String name;

    public CreateCategoryRequest() {}
    public CreateCategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
