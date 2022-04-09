package com.sparta.webmini2.controller;

import com.sparta.webmini2.dto.SignupRequestDto;
import com.sparta.webmini2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    // 회원 로그인 페이지
//    @GetMapping("/user/login")
//    public String login() {
//        return "login";
//    }
//
//    // 에러 문구 표시
//    @GetMapping("/user/login/error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login";
//    }

//    // 회원 가입 페이지
//    @GetMapping("/user/signup")
//    public String signup() {
//        return "signup";
//    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public  String registerUser(@RequestBody SignupRequestDto requestDto, Model model) {
        if (userService.registerUser(requestDto).equals("")) {
            return "success";
        } else {
            model.addAttribute("errortext", userService.registerUser(requestDto));
            return "false";
        }
    }}



//    // 유저 로그인 체크
//    @GetMapping("/api/userCheck")
//    public String userCheck(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        if (userDetails != null) {
//            return userDetails.getUser().getUsername();
//        }
//        return "";
//    }
//}