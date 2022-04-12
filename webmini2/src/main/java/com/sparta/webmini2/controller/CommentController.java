package com.sparta.webmini2.controller;

import com.sparta.webmini2.dto.CommentRequestDto;
import com.sparta.webmini2.dto.CommentResponseDto;
import com.sparta.webmini2.model.Comment;
import com.sparta.webmini2.repository.CommentRepository;

import com.sparta.webmini2.service.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository CommentRepository;
    private final CommentService CommentService;

    //     댓글 전체 조회
    @GetMapping("/api/comments/{postId}")
    public Page<Comment> getComment(@PathVariable Long postId , @PageableDefault(size = 5) Pageable pageable) {
        return CommentService.getComment(postId,pageable);
    }
    // 댓글 생성
    @PostMapping("/api/comments/{postId}")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto){
        return CommentService.createComment(requestDto);
    }
    // 댓글 수정
    @PutMapping("/api/comments/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        return CommentService.update(commentId, requestDto);
    }
    //댓글 삭제
    @DeleteMapping("/api/comments/{commentId}")
    public CommentResponseDto deleteComment(@PathVariable Long commentId) {
        return CommentService.deleteComment(commentId);
    }
}