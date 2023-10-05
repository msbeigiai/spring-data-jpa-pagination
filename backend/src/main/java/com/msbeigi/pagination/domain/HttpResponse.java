package com.msbeigi.pagination.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record HttpResponse(String timestamp,
                           Integer statusCode,
                           HttpStatus status,
                           String message,
                           Map<?, ?> data) {
}
