package com.zurimokato.ms_product.infrastructure.adapter.in.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class GenericResponse {
    private String message;
    private String code;
    private Object data;
    private HttpStatus httpStatus;

    public static GenericResponse success() {
        return GenericResponse.builder()
                .code("200")
                .message("OK")
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
