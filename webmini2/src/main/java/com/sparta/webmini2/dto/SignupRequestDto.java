package com.sparta.webmini2.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String username;
    private String nickName;
    private String password;
    private String passwordCheck;
    private String position;
}
