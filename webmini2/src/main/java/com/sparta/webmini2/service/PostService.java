package com.sparta.webmini2.service;

import com.sparta.webmini2.dto.PostRequestDto;
import com.sparta.webmini2.model.Post;
import com.sparta.webmini2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class PostService {
        private final PostRepository PostRepository;

        @Transactional
        public Long update(Long postId, PostRequestDto requestDto) {
            Post post = PostRepository.findById(postId).orElseThrow(
                    () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
            );
            post.update(requestDto);
            return post.getPostId();
        }

    }

