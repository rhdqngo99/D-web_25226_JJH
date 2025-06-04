package com.koreait.www.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"com.koreait.www.controller", "com.koreait.www.service"})
public class ServletConfigration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// resources 경로설정 / 나중에 파일 업로드에 대ㅔ한 경로설정 추가
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// InternalResourceViewResolver
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		
		registry.viewResolver(viewResolver);
	}
	
}
