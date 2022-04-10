package com.sparta.webmini2.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private boolean result;
    private String error;
    private String username;
    private String nickName;
    private String position;

    public ResponseDto(boolean result) {
        this.result = result;
    }

}
