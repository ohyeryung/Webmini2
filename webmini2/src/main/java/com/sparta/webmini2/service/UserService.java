package com.sparta.webmini2.service;

import com.sparta.webmini2.dto.ResponseDto;
import com.sparta.webmini2.dto.SignupRequestDto;
import com.sparta.webmini2.model.User;
import com.sparta.webmini2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
//    private final JwtTokenUtils jwtTokenUtils;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    // 회원가입 요청
    public ResponseDto registUser(SignupRequestDto requestDto) {

        ResponseDto responseDto = null;

        String username = requestDto.getUsername();

        String  nickName = requestDto.getNickName();

        // 비밀번호 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());

        String position = requestDto.getPosition();

        // 회원 정보 저장
        User user = new User(username, nickName, password, position);
        userRepository.save(user);
        responseDto = new ResponseDto(true);

        return responseDto;
    }

//    public ResponseDto login(SignupRequestDto requestDto) {
//        ReturnUser returnUser
//    }

//    //로그인 서비스
//    //로그인 dto에 username과 password를 가지고 존재하는지 확인을 해줍니다 userrepository를 이용하여 db에서 체크
//    //존재하지 않거나 비밀번호가 맞지 않을시 오류를 내주고 그렇지 않을경우 토큰을 발행합니다.
//    public ReturnUser login(SignupRequestDto requestDto) {
//        ReturnUser returnUser = new ReturnUser();
//        try {
//
//            User user = userRepository.findByUsername(requestDto.getUsername())
//                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
//            if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
//                throw new IllegalArgumentException("비밀번호를 다시 확인해 주세요.");
//            }
//            returnUser.setToken(jwtTokenUtils.generateJwtToken(user.getUsername()));
//            returnUser.setUsername(user.getUsername());
//            returnUser.setNickname(user.getNickName());
//            return returnUser;
//        } catch (IllegalArgumentException e) {
//            returnUser.setMsg(e.getMessage());
//            return returnUser;
//        }
//    }


}
