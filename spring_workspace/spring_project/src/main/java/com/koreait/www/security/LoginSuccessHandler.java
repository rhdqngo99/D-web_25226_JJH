package com.koreait.www.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.koreait.www.repository.UserDAO;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private UserDAO udao;
	
	// redirect 데이터를 가지고 리다이렉트 경로로 이동하는 역할
	private RedirectStrategy redStr = new DefaultRedirectStrategy();
	
	//세션의 캐쉬정보, 직전의 url 정보를 가지고 있음.
	private RequestCache reqCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// 1. lastLogin 기록 => 로그인 후 가야하는 경로 설정
		// authentication => username => getName()
		String authEmail = authentication.getName();
		int isOk = udao.updateLastLogin(authEmail);
		
		String authUrl = "/board/list"; // 직전 url이 없을 경우
		
		// 시큐리티에서 로그인을 시도해서 실패하면 실패기록이 남게 됨.
		// 2.로그인을 성공하면 기존 실패했던 기록을 삭제
		// 세션 가져오기
		HttpSession ses = request.getSession();
		if(ses == null) {
			return;
		}else {
			// 세션의 객체 삭제 (기존 실패했던 기록을 삭제)
			ses.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		
		// 3. 로그인 직전 url로 연결
		SavedRequest saveRequest = reqCache.getRequest(request, response);
		redStr.sendRedirect(request, response, 
				saveRequest != null? saveRequest.getRedirectUrl() : authUrl);
	}

}