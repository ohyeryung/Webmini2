package com.sparta.webmini2.model;

import com.sparta.webmini2.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Comment extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long commentId;

    // nullable = false 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String comment_content;

    @Column(nullable = false)
    private Long postId;


    // 게시글 생성
    public Comment(CommentRequestDto requestDto) {

        this.nickName = requestDto.getNickName();
        this.userId = requestDto.getUserId();
        this.postId = requestDto.getPostId();
        this.comment_content = requestDto.getComment_content();
    }


    // 게시글 수정
    public void update(CommentRequestDto requestDto) {

//        this.username = requestDto.getUsername();
        this.comment_content = requestDto.getComment_content();
//        this.contentsId = requestDto.getContentsId();

    }
}