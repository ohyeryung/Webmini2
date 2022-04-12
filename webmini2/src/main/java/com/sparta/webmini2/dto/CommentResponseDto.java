package com.sparta.webmini2.dto;

import lombok.Getter;

@Getter
public class CommentResponseDto {
    private boolean result;

    public CommentResponseDto(boolean result) {
        this.result = result;
    }
}
