package com.koreait.www.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletConfigration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		// filter Encoding 설정
		CharacterEncodingFilter encoding = new CharacterEncodingFilter();
		encoding.setEncoding("UTF-8"); // 들어오는 객체 인코딩 설정
		encoding.setForceEncoding(true); // 밖으로 나가는 데이터도 인코딩 설정하겠다.
		return super.getServletFilters();
		
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		// 기타 사용자 설정 => CustomizeRegistration
		// 파일 업로드 경로, 사용자 지정 익셉션 처리 설정 
		super.customizeRegistration(registration);
	}
	

}
