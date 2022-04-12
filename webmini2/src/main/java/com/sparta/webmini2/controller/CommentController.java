package com.sparta.webmini2.controller;

import com.sparta.webmini2.dto.CommentRequestDto;
import com.sparta.webmini2.model.Comment;
import com.sparta.webmini2.model.Post;
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
    public Comment createComment(@RequestBody CommentRequestDto requestDto){
        return CommentService.createComment(requestDto);
    }
    // 댓글 수정
    @PutMapping("/api/comments/{commentId}")
    public Long updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        CommentService.update(commentId, requestDto);
        return commentId;
    }
    //댓글 삭제
    @DeleteMapping("/api/comments/{commentId}")
    public Long deleteComment(@PathVariable Long commentId) {
        CommentService.deleteComment(commentId);
        return commentId;
    }
}