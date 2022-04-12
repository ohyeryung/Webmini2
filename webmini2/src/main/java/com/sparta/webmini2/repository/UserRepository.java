package com.sparta.webmini2.repository;

import com.sparta.webmini2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    // 아이디 중복 검사
    boolean existsByUsername(String username);

    // 닉네임 중복 검사
    boolean existsByNickName(String nickName);

}
