package com.koreait.www.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.koreait.www.domain.UserVO;
import com.koreait.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthUserService implements UserDetailsService {
	
	@Autowired
	private UserDAO udao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username, password 인증용 토근 생성 => DB에서 확인
		// 리턴타입 UserDetails : 인증된 객체 리턴 <id, password, auth>
		
		// DB user 테이블에서 username이 일치하는 객체를 리턴
		// username : 로그인을 시도하는 id => email
		UserVO uvo = udao.getUser(username);
		
		if(uvo == null) {
			throw new UsernameNotFoundException(username);
		}
		
		uvo.setAuthList(udao.getAuthList(username));
		log.info(">>> userDetails >> {}", uvo);
		
		return new AuthUser(uvo);
	}

}
