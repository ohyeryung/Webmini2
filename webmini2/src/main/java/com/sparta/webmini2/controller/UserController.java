package com.sparta.webmini2.controller;

import com.sparta.webmini2.dto.SignupRequestDto;
import com.sparta.webmini2.service.UserService;
import com.sparta.webmini2.validator.UserInfoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserInfoValidator signUpValidator;
    private final UserService userService;

    // 회원 가입 요청 처리
    @PostMapping("/api/signup")
    public String registUser(@RequestBody SignupRequestDto requestDto, Errors errors, Model model) {
        String message = signUpValidator.getValidMessage(requestDto, errors);
        System.out.println(message);
        if (message.equals("회원가입 성공")) {
            userService.registUser(requestDto);
            return "true";
        }
        model.addAttribute("message", message);
        return "false";
    }


//    @PostMapping("api/login")
//    public
}
