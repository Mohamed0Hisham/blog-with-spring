package com.ascendant.blog.domain.dtos;

import java.util.List;

public class ApiErrorResponse {
    private final int status;
    private final String message;
    private final List<FieldError> fieldErrors;

    private ApiErrorResponse(Builder builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.fieldErrors = builder.fieldErrors;
    }

    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    // --- Builder ---
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int status;
        private String message;
        private List<FieldError> fieldErrors;

        public Builder status(int status) {
            this.status = status;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder fieldErrors(List<FieldError> fieldErrors) {
            this.fieldErrors = fieldErrors;
            return this;
        }
        public ApiErrorResponse build() {
            return new ApiErrorResponse(this);
        }
    }

    // --- Inner class for field errors ---
        public record FieldError(String field, String message) {}
}
