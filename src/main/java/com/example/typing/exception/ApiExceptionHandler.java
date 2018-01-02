package com.example.typing.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private ApiError createApiError(Exception ex) {
        ApiError apiError = new ApiError();
        apiError.setMassage(ex.getMessage());
        apiError.setDocumentationUrl("http://example.com/api/errors");
        return apiError;
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        ApiError apiError = createApiError(ex);
        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }
}
