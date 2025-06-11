package com.koreait.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.koreait.www.security.CustomAuthUserService;
import com.koreait.www.security.LoginFailureHandler;
import com.koreait.www.security.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 비밀번호 암호화 객체 빈 생성 PasswordEncoder
	@Bean
	public PasswordEncoder bcPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// SuccessHandler 객체 빈 생성 => 사용자 커스텀 객체
	@Bean
	public AuthenticationSuccessHandler authSuccessHandler() {
		return new LoginSuccessHandler();
	}
	
	// FailureHandler 객체 빈 생성 => 사용자 커스텀 객체
	@Bean
	public AuthenticationFailureHandler authFailureHandler() {
		return new LoginFailureHandler();
	}
	
	// UserDetail 객체 빈 생성 => 사용자 커스텀 객체
	@Bean
	public UserDetailsService customDetailsService() {
		return new CustomAuthUserService();
	}
	
	// UsernameNotFoundException 숨기지 않도록 설정
		@Bean
		public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		    provider.setUserDetailsService(userDetailsService);
		    provider.setPasswordEncoder(passwordEncoder);
		    
		    provider.setHideUserNotFoundExceptions(false);
		    
		    return provider;
		}
		

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// 인증용 객체 생성 매니저 설정
//			auth.userDetailsService(customDetailsService())
//				.passwordEncoder(bcPasswordEncoder());
			
			// 위 코드의 Provider는 setHideUserNotFoundExceptions(true)가 default
			// 즉, UsernameNotFoundException 이 자동으로 BadcredentialsException 으로 포장
			// 외부로 전달되지 않기 때문에 따로 DaoAuthenticationProvider 에서 setHideUserNotFoundException 을 false 로 변경.
			
			// UsernameNotFoundException 에러메세지 숨기기 비활성화
			auth.authenticationProvider(authenticationProvider(customDetailsService(), bcPasswordEncoder()));
		}

	

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// 인증용 객체 생성 메니저 설정
//		auth.userDetailsService(customDetailsService())
//			.passwordEncoder(bcPasswordEncoder());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 권한에 따른 주소 맵핑 설정
		// 로그인 로그아웃 구성정보 설정
		// csrf() : csrf 공격에 대한 설정 풀기 
		http.csrf().disable();
		
		//권한에 따른 승인 요청
		//antMatchers : 접근을 허용하는 경로
		//permitAll : 누구나 접근이 가능한 경로
		//hasRole('권한') : 해당 권한 확인  ROLE_ 포함 ADMIN => ROLE_ADMIN 인지
		//authenticated(): 인증된 사용자만 가능한 경로
		//ADMIN > MANAGER > USER
		http.authorizeRequests()
			.antMatchers("/user/list").hasRole("ADMIN")
			.antMatchers("/","/user/login","/user/register",
					"/board/list","/board/detail","/upload/**",
					"/resources/**","/comment/**").permitAll()
			.anyRequest().authenticated();
		
		//로그인 페이지 구성 : username => email / password => pwd
		http.formLogin()
			.usernameParameter("email")
			.passwordParameter("pwd")
			.loginPage("/user/login") // controller에 주소 요청 맵핑 값은 있어어야 함.(필수)
//			.defaultSuccessUrl("/")  // successHandler 없는 경우
//			.failureUrl("/"); // failureHandler 없는 경우
			.successHandler(authSuccessHandler())
			.failureHandler(authFailureHandler());
		
		//로그아웃 구성 : method = "post" 
		http.logout()
			.logoutUrl("/user/logout")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/");
		
	}

}
