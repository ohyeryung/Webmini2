package com.sparta.webmini2.controller;

import com.sparta.webmini2.dto.ResponseDto;
import com.sparta.webmini2.dto.SignupRequestDto;
import com.sparta.webmini2.sercurity.UserDetailsImpl;
import com.sparta.webmini2.service.UserService;
import com.sparta.webmini2.validator.UserInfoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public ResponseDto registUser(@RequestBody SignupRequestDto requestDto, Errors errors) {
        String message = signUpValidator.getValidMessage(requestDto, errors);
        System.out.println(message);
        if (message.equals("회원가입 성공")) {
            return userService.registUser(requestDto);
        } else {
            ResponseDto responseDto = new ResponseDto(false, message);
            return responseDto;
        }
    }

    // 로그인
//    @PostMapping("api/login")
//    public ResponseDto loginUser(@RequestBody SignupRequestDto requestDto) {
//        return new ResponseDto(true);
//    }




    @PostMapping("/api/idCheck")
    public ResponseDto idDueCheck(@RequestBody SignupRequestDto requestDto, String username) {
        String message = signUpValidator.idDueCheck(requestDto) ;
        if(message == "이미 사용중인 id입니다"){
            return new ResponseDto(false, message);
        }
        return new ResponseDto(true, message);
    }


    // 로그인 여부 확인
    @PostMapping("/api/islogin")
    public ResponseDto islogin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return new ResponseDto(userDetails.getUsername(), userDetails.getUserNickName(), userDetails.getUserPosition());
    }


}
