package com.koreait.www.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// 시큐리티 필터들을 활성화 시켜줘야 함.
// AbstractSecurityWebApplicationInitializer 상속 받아야 시큐리티 필터들이 활성화 됨.
public class SecurityInitalizer extends AbstractSecurityWebApplicationInitializer{

}
