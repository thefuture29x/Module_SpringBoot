package com.example.module_javaspingboot_day15.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.List;


@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    public static final int OK_CODE = 200_000;
    private final Metadata meta = new Metadata();
    private T data;
    private Object data2;
    public static <T> Response<T> ofSucceeded(T data) {
        Response<T> response = new Response<>();
        response.data = data;
        response.meta.code = OK_CODE;
        return response;
    }

    public static <T> Response<List<T>> ofSucceeded(Page<T> data) {
        Response<List<T>> response = new Response<>();
        response.data = data.getContent();
        response.meta.code = OK_CODE;
        response.meta.page = data.getPageable().getPageNumber();
        response.meta.size = data.getPageable().getPageSize();
        response.meta.total = data.getTotalElements();
        return response;
    }
//  Hàm custom response hiển thị response body với đầy đủ thông tin data và thông tin cho pagination
    public static <T> Response<Flux<T>> ofSucceeded(List data, Pageable pageable, Long totalItem) {
        Response<Flux<T>> response = new Response<>();
        response.data2 = data;                          // set list Teacher vào data2
        response.meta.code = OK_CODE;                   // set status code
        response.meta.page = pageable.getPageNumber();  // set page hiển thị trong response body từ giá trị pageable truyền từ controller
        response.meta.size = pageable.getPageSize();    // set size hiển thị trong response body từ giá trị pageable truyền từ controller
        response.meta.total = totalItem;                // set totalItem hiển thị trong response body từ giá trị truyền từ controller
        return response;
    }

    public static <T> ResponseEntity<Response<T>> ofFailedEntity(BusinessErrorCode errorCode) {
        return ofFailedEntity(errorCode, errorCode.getMessage());
    }

    public static <T> ResponseEntity<Response<T>> ofFailedEntity(BusinessErrorCode errorCode, String message) {
        return ofFailedEntity(errorCode, message);
    }

//    public static <T> ResponseEntity<Response<T>> ofFailedEntity(BusinessErrorCode errorCode, String message) {
//        Response<T> response = new Response<>();
//        response.meta.code = errorCode.getCode();
//        response.meta.message = message;
//        return new ResponseEntity<>(response, errorCode.getHttpStatus());
//    }

    public static <T> Response<T> ofFailed(BusinessErrorCode errorCode) {
        return ofFailed(errorCode, errorCode.getMessage());
    }

    public static <T> Response<T> ofFailed(BusinessErrorCode errorCode, String message) {
        return ofFailed(errorCode, message);
    }

//    public static <T> Response<T> ofFailed(BusinessErrorCode errorCode, String message, List<FieldViolation> errors) {
//        Response<T> response = new Response<>();
//        response.meta.code = errorCode.getCode();
//        response.meta.message = errorCode.getMessage();
//        response.meta.errors = errorCode.getErrors();
//        return response;
//    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Metadata {
        int code;
        Integer page;
        Integer size;
        Long total;
        String message;
    }
}
