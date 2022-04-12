package com.sparta.webmini2.sercurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AuthFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username"); // request에서 getParameter를 사용하여 "username"에 대한 정보를 가져올 수 있다.

        String errormessage = "아이디와 비밀번호를 확인해주세요.";

        if (exception instanceof DisabledException) {
            errormessage = "아이디와 비밀번호를 확인해주시라구요!!!.";
        }
//        else if (exception instanceof CredentialsExpiredException) {
//            errormessage = "비밀번호가 만료되었습니다.";
//       } else if (exception instanceof BadCredentialsException) {
//        } errormessage = "비밀번호가 일치하지 않습니다.";

        System.out.println("로그인 실패 시 에러메세지");
        System.out.println(errormessage);


        System.out.println("로그인 실패한 username");
        System.out.println(username);


        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        Map<String, Object> data = new HashMap<>();
        data.put(
                "timestamp",
                Calendar.getInstance().getTime());
        data.put(
                "exception",
                exception.getMessage());

        response.getOutputStream()
                .println(objectMapper.writeValueAsString(data));

//        response.sendRedirect("api/login?Error");
    }
}
