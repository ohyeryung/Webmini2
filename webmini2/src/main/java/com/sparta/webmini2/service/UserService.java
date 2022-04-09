package com.sparta.webmini2.service;


import com.sparta.webmini2.dto.SignupRequestDto;
import com.sparta.webmini2.model.User;
import com.sparta.webmini2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public String registerUser(SignupRequestDto requestDto) {
        String error = "";
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String passwordCheck = requestDto.getPasswordCheck();
        String nickName = requestDto.getNickName();
        String position = requestDto.getPosition();

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        String pattern = "^[a-zA-Z0-9]*$";

        if (found.isPresent()) {
            return "중복된 id 입니다.";
        }

        if (username.length() < 3) {
            System.out.println(username);
            return "ID을 4자 이상 입력하세요";
        } else if (!Pattern.matches(pattern, username)) {
            return "알파벳 대소문자와 숫자로만 입력하세요";
        } else if (!password.equals(passwordCheck)) {
            return "비밀번호가 일치하지 않습니다";
        } else if (password.length() < 5) {
            return "비밀번호를 6자 이상 입력하세요";
        } else if (password.contains(username)) {
            return "비밀번호에 닉네임을 포함할 수 없습니다.";
        }

        // 패스워드 인코딩
        password = passwordEncoder.encode(password);
        requestDto.setPassword(password);

        User user = new User(username, password, nickName, position);
        userRepository.save(user);
        return error;
    }



}