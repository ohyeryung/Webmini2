package com.sparta.webmini2.controller;

import com.sparta.webmini2.dto.PostRequestDto;
import com.sparta.webmini2.dto.PostResponseDto;
import com.sparta.webmini2.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {


    private final com.sparta.webmini2.service.PostService PostService;



    // 게시글 전체 조회  ,페이징처리
    @GetMapping("/api/post")
    public Page<Post> getPost(@PageableDefault(size = 5) Pageable pageable
//            @RequestParam("page")  int page,
//            @RequestParam("size") int size,
//            @RequestParam ("sortBy")  String sortBy,
//            @RequestParam ("isAsc")  boolean isAsc
    ) {
//
        return PostService.getPost(pageable);
    }

//     게시글 특정 조회
    @GetMapping("/api/post/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return PostService.getPost(postId);
    }
    // 게시글 생성
    @PostMapping("/api/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){
        return PostService.createPost(requestDto);
    }
    //게시글 수정
    @PutMapping("/api/post/{postId}")
    public Long updatePost(@PathVariable Long postId, @RequestBody PostRequestDto requestDto) {
        PostService.update(postId, requestDto);
        return postId;
    }
    //게시글 삭제
    @DeleteMapping("/api/post/{postId}")
    public Long deletePost(@PathVariable Long postId) {
        PostService.deletePost(postId);
        return postId;
    }
}
