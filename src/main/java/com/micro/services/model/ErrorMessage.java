package com.micro.services.model;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    HttpStatus httpStatus;
    String message;

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ErrorMessage() {
    }

    public String getMessage() {
        return message;
    }
}
