package com.patika.bloghubservice.exception;

import com.patika.bloghubservice.dto.response.GenericResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public GenericResponse handleBlogHubException(BusinessException businessException) {
        return GenericResponse.failed(businessException.getMessage());
    }
}
