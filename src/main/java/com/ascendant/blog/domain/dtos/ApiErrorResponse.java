package com.ascendant.blog.domain.dtos;

import java.util.List;

public class ApiErrorResponse {
    private int status;
    private String message;
    private List<FieldError> fieldErrors ;

    public ApiErrorResponse(){}
    public ApiErrorResponse(int status, String message, List<FieldError> fieldErrors) {
        this.status = status;
        this.message = message;
        this.fieldErrors = fieldErrors;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public static class FieldError {
        private String field;
        private String message;

        public FieldError() {}
        public FieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }
        public void setField(String field) {
            this.field = field;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
    }
}
