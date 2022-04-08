package com.sparta.webmini2.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {

    private String userId;
    private String nickName;
    private String comment_content;
    private Long postId;
}