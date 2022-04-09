package com.sparta.webmini2.service;

import com.sparta.webmini2.dto.PostRequestDto;
import com.sparta.webmini2.model.Post;
import com.sparta.webmini2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class PostService {
        private final PostRepository PostRepository;
        //게시글 생성
        public Post createPost(PostRequestDto requestDto) {

            Post post = new Post(requestDto);

            return PostRepository.save(post);
        }
        //게시글 전체 조회 , 페이징처리
        public Page<Post> getPost(Pageable pageable) {


            return PostRepository.findAllByOrderByModifiedAtDesc(pageable);
        }
        //게시글 특정 조회
        public Post getPost(Long postId) {
            Post post = PostRepository.findById(postId).orElseThrow(
                    () -> new IllegalArgumentException("postId가 존재하지 않습니다."));
            return post;
        }
        //게시글 수정
        @Transactional
        public Long update(Long postId, PostRequestDto requestDto) {
            Post post = PostRepository.findById(postId).orElseThrow(
                    () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
            );
            post.update(requestDto);
            return post.getPostId();
        }
        //게시글 삭제
        public Long deletePost(Long postId) {
            PostRepository.deleteById(postId);
            return postId;
        }
    }

