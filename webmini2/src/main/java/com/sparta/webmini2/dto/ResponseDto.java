package com.sparta.webmini2.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private boolean result;
    private String errormessage;
    private String username;
    private String nickName;
    private String position;

    public ResponseDto(boolean result) {
        this.result = result;
    }

    // 회원가입 response
    public ResponseDto(boolean result, String errormessage) {
        this.result = result;
        this.errormessage = errormessage;
    }

    // 로그인 여부 확인 response
    public ResponseDto(String username, String userNickName, String userPosition) {
        this.username = username;
        this.nickName = userNickName;
        this.position = userPosition;
    }

}
