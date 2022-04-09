package com.sparta.webmini2.controller;

import com.sparta.webmini2.dto.PostRequestDto;
import com.sparta.webmini2.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final com.sparta.webmini2.repository.PostRepository PostRepository;
    private final com.sparta.webmini2.service.PostService PostService;



    // 게시글 전체 조회
    @GetMapping("/api/post")
    public List<Post> getPost() {
        return PostRepository.findAllByOrderByModifiedAtDesc();
    }

//     게시글 특정 조회
    @GetMapping("/api/post/{postId}")
    public Post getPost(@PathVariable Long postId) {
        Post post = PostRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("postId가 존재하지 않습니다."));
        return post;
    }

    // 게시글 생성
    @PostMapping("/api/post")
    public Post createPost(@RequestBody PostRequestDto requestDto){

        Post post = new Post(requestDto);

        return PostRepository.save(post);
    }

    @PutMapping("/api/post/{postId}")
    public Long updatePost(@PathVariable Long postId, @RequestBody PostRequestDto requestDto) {
        PostService.update(postId, requestDto);
        return postId;
    }

    @DeleteMapping("/api/post/{postId}")
    public Long deletePost(@PathVariable Long postId) {
        PostRepository.deleteById(postId);
        return postId;
    }

}
