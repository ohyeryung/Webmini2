package com.sparta.webmini2.model;

import com.sparta.webmini2.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Post extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long postId;

    // nullable = false 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String post_content;

    @Column(nullable = false)
    private int frontNum;

    @Column(nullable = false)
    private int backNum;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = false)
    private String userId;

//    @Column(nullable = false)
//    private String createdAt;

    public Post(String title, String nickName, String post_content, int frontNum, int backNum, boolean completed, String userId) {
        this.title = title;
        this.nickName = nickName;
        this.post_content = post_content;
        this.frontNum = frontNum;
        this.backNum = backNum;
        this.completed = completed;
        this.userId = userId;
//        this.createdAt = createdAt;
    }

    // 게시글 생성
    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.nickName = requestDto.getNickName();
        this.post_content = requestDto.getPost_content();
        this.frontNum = requestDto.getFrontNum();
        this.backNum = requestDto.getBackNum();
        this.completed = requestDto.isCompleted();
        this.userId = requestDto.getUserId();
//        this.createdAt = requestDto.getCreatedAt();

    }
}