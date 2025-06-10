package com.koreait.www.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// 로그인을 시도했던 이메일
		String authEmail = request.getParameter("email");
		String errorMessage;
		
		// BadCredentialsException || InternalAuthenticationServiceException ||
		// UsernameNotFoundException
		// exception 발생시 메시지 저장
		log.info(">>>> failure exception >> {}", exception.getMessage().toString());
		if(exception instanceof UsernameNotFoundException) {
			errorMessage = "아이디가 일치하지 않습니다.";
		}else if(exception instanceof BadCredentialsException) {
			errorMessage = "비밀번호가 일치하지 않습니다.";
		}else if(exception instanceof InternalAuthenticationServiceException) {
			errorMessage ="관리자에게 문의하세요.";
		}else {
			errorMessage ="관리자에게 문의하세요.";
		}
		
		log.info(">>>> failure errorMessage >> {}",errorMessage);
		
		request.setAttribute("email", authEmail);
		request.setAttribute("errmsg", errorMessage);
		
		request.getRequestDispatcher("/user/login?error").forward(request, response);
	}

}