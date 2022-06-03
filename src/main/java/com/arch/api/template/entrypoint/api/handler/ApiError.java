package com.arch.api.template.entrypoint.api.handler;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ApiError {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private List<ApiValidationError> fieldErrors;

    private ApiError() {
        timestamp = LocalDateTime.now();
        fieldErrors = new ArrayList<>();
    }

    ApiError(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }
}
