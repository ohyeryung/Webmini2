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
    public List<Post> getPost(
//            @RequestParam("page")  int page,
//            @RequestParam("size") int size,
//            @RequestParam ("sortBy")  String sortBy,
//            @RequestParam ("isAsc")  boolean isAsc
    ) {
        return PostService.getPost();
    }

//     게시글 특정 조회
    @GetMapping("/api/post/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return PostService.getPost(postId);
    }
    // 게시글 생성
    @PostMapping("/api/post")
    public Post createPost(@RequestBody PostRequestDto requestDto){
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
