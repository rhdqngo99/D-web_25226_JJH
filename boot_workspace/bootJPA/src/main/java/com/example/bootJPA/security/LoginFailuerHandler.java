package com.example.bootJPA.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class LoginFailuerHandler implements AuthenticationFailureHandler {

    private RedirectStrategy redirectStrategy =
            new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage; // 에러 메시지 저장할 변수
        String loginFailEmail = request.getParameter("email");

        if(exception instanceof BadCredentialsException){
            // 아이디 + password 오류
            errorMessage = "email / password가 일치하지 않습니다.!";
        }else if(exception instanceof InternalAuthenticationServiceException){
            errorMessage = "관리자에게 문의해주세요.";
        }else{
            errorMessage = "관리자에게 문의해주세요.";
        }
        log.info(">>>> loginFailEmail >> {}", loginFailEmail);
        log.info(">>>> errorMessage >> {}", errorMessage);

        String url = "/user/login";
        request.getSession().setAttribute("email", loginFailEmail);
        request.getSession().setAttribute("errmsg", errorMessage);

        // encode 처리
//        errorMessage = URLEncoder.encode(errorMessage, StandardCharsets.UTF_8);
//        setDefaultFailureUrl("/user/login?error=true&email="+loginFailEmail+"&errmsg="+errorMessage);
//        super.onAuthenticationFailure(request,response,exception);

//        String url = "/user/login?error=true&email="+loginFailEmail+"&errmsg="+errorMessage;

        redirectStrategy.sendRedirect(request, response, url);
    }
}