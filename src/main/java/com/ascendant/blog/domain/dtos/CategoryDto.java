package com.ascendant.blog.domain.dtos;

import java.util.UUID;

public class CategoryDto {
    private final UUID id;
    private final String name;
    private final Long postCount;

    private CategoryDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.postCount = builder.postCount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPostCount() {
        return postCount;
    }

    // Builder pattern
    public static class Builder {
        private UUID id;
        private String name;
        private Long postCount;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder postCount(Long postCount) {
            this.postCount = postCount;
            return this;
        }

        public CategoryDto build() {
            return new CategoryDto(this);
        }
    }

    // static factory method
    public static Builder builder() {
        return new Builder();
    }
}
