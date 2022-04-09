package com.sparta.webmini2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String nickName;
    private String post_content;
    private int frontNum;
    private int backNum;
    private boolean completed;
    private String username;
//    private String createdAt;

}
