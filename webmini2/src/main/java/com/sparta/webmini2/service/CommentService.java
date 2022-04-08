package com.sparta.webmini2.service;


import com.sparta.webmini2.dto.CommentRequestDto;
import com.sparta.webmini2.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final com.sparta.webmini2.repository.CommentRepository CommentRepository;


    //댓글 수정
    @Transactional
    public Long update(Long id, CommentRequestDto requestDto) {
        Comment comment = CommentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment.getCommentId();
    }
}