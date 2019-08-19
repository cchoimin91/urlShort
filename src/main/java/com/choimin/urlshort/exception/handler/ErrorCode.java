package com.choimin.urlshort.exception.handler;

import lombok.Getter;

public enum ErrorCode {

    CODE_0000("0000","파라미터 오류 발생"),
    CODE_0001("0001","리다이랙트 에러 발생");


    @Getter
    private String code;

    @Getter
    private String description;

    ErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
