package com.example.module_javaspringboot_day12.util;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class BusinessErrorCode implements Serializable {
    private static final long serialVersionUID = -2005206237438722822L;
    private final int code;
    private final String message;
    private HttpStatus httpStatus;

    public BusinessErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public BusinessErrorCode(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.httpStatus = status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
