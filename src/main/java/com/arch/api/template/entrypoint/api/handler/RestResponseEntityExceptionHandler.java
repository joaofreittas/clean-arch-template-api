package com.arch.api.template.entrypoint.api.handler;

import com.arch.api.template.core.exception.PersonNotFound;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers,
        final HttpStatus status,
        final WebRequest request) {

        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();

        List<ApiValidationError> subErrors = new ArrayList<>();
        fieldErrors.forEach(error -> {
            subErrors.add(
                new ApiValidationError(
                    error.getField(),
                    error.getDefaultMessage()));
        });

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Arguments are not valid!");
        apiError.setFieldErrors(subErrors);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(PersonNotFound.class)
    protected ResponseEntity<Object> handleEntityNotFound(PersonNotFound ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
