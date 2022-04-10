package com.sparta.webmini2.service;

import com.sparta.webmini2.dto.PostRequestDto;
import com.sparta.webmini2.dto.PostResponseDto;
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
    public PostResponseDto createPost(PostRequestDto requestDto) {
        PostResponseDto postResponseDto = null;
        Post post = new Post(requestDto);
        int frontNum = requestDto.getFrontNum();
        int backNum = requestDto.getFrontNum();

        if (frontNum == 0 && backNum == 0) {
            throw new IllegalArgumentException("모집인원을 정해주세요");
        }
        PostRepository.save(post);
        postResponseDto = new PostResponseDto(true);

        return postResponseDto;
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
    public PostResponseDto update(Long postId, PostRequestDto requestDto) {
        PostResponseDto postResponseDto = null;
        Post post = PostRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        post.update(requestDto);
//        post.getPostId();
        postResponseDto = new PostResponseDto(true);
        return postResponseDto;
    }

    //게시글 삭제
    public PostResponseDto deletePost(Long postId) {
        PostResponseDto postResponseDto = null;
        PostRepository.deleteById(postId);
        postResponseDto = new PostResponseDto(true);
        return postResponseDto;
    }
}

