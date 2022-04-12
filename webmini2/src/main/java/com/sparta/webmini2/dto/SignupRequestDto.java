package com.sparta.webmini2.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String passwordCheck;
    private String nickName;
    private String position;

    public SignupRequestDto(String username, String password, String passwordCheck,String nickName,String position) {
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.nickName = nickName;
        this.position = position;
    }
}