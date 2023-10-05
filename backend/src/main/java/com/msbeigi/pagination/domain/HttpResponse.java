package com.msbeigi.pagination.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {
    protected String timestamp;
    protected Integer statusCode;
    protected HttpStatus status;
    protected String message;
    protected Map<?, ?> data;
}
