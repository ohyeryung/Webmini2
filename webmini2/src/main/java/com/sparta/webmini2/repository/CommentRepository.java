package com.sparta.webmini2.repository;


import com.sparta.webmini2.model.Comment;
import com.sparta.webmini2.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByPostIdOrderByCreatedAtDesc(Long postId , Pageable pageable);
}