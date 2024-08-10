package com.patika.bloghubuserservice.dto.response;

import com.patika.bloghubuserservice.constant.GenericResponseMessages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericResponse<T> {

    private String status;

    private String message;

    private HttpStatus httpStatus;

    private T data;

    public static <T> GenericResponse<T> success(T data, HttpStatus httpStatus) {
        return GenericResponse.<T>builder()
                .httpStatus(httpStatus)
                .status(GenericResponseMessages.SUCCESS)
                .message(null)
                .data(data)
                .build();
    }

    public static <T> GenericResponse<T> failed(String message) {
        return GenericResponse.<T>builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(GenericResponseMessages.FAILED)
                .message(message)
                .data(null)
                .build();
    }

}
