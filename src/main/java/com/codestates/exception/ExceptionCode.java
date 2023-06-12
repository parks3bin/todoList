package com.codestates.exception;

import lombok.Getter;

// TODO 수정됨
public enum ExceptionCode {
    TODO_NOT_FOUND(404, "Coffee not found"),
    TODO_TITLE_EXISTS(409, "Coffee Code exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
