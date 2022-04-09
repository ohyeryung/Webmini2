package com.sparta.webmini2.service;


import com.sparta.webmini2.dto.CommentRequestDto;
import com.sparta.webmini2.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final com.sparta.webmini2.repository.CommentRepository CommentRepository;

    //댓글 생성
    public Comment createComment(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return CommentRepository.save(comment);
    }
    //댓글 전체조회
    public List<Comment> getComment(Long postId) {
        return CommentRepository.findAllByPostIdOrderByCreatedAtDesc(postId);
    }
    //댓글 수정
    @Transactional
    public Long update(Long id, CommentRequestDto requestDto) {
        Comment comment = CommentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment.getCommentId();
    }
    //댓글 삭제
    public Long deleteComment(Long commentId) {
        CommentRepository.deleteById(commentId);
        return commentId;
    }
}