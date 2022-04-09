package com.sparta.webmini2.controller;

import com.sparta.webmini2.dto.SignupRequestDto;
import com.sparta.webmini2.service.UserService;
import com.sparta.webmini2.validator.UserInfoValidator;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserInfoValidator signUpValidator;
    private final UserService userService;

    // 회원 가입 요청 처리
    @PostMapping("/api/signup")
    public String registUser(@RequestBody SignupRequestDto requestDto, Errors errors, Model model) {
        String message = signUpValidator.getValidMessage(requestDto, errors);
        if (message.equals("회원가입 성공")) {
            return "sucess";
        }
        model.addAttribute("message", message);
        return "fail";
    }
}
