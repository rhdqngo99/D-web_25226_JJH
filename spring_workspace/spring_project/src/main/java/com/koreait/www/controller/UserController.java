package com.koreait.www.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.www.domain.UserVO;
import com.koreait.www.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RequestMapping("/user/*")
@Slf4j
@Controller
public class UserController {
	private final UserService usv;
	private final BCryptPasswordEncoder bcEncoder;
	
	// mapping 경로와 jsp 경로가 같으면 void 처리가능.
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(UserVO uvo) {
		// 회원가입 처리
		log.info(">>>>user vo >>{}", uvo);
		// password 암호화
		uvo.setPwd(bcEncoder.encode(uvo.getPwd()));
		int isOk = usv.insert(uvo);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, RedirectAttributes re) {
		// 실제 로그인시에는 Security의 filter에서 가져감.
		// 로그인 실패시 다시 로그인 페이지로 돌아와 오류 메시지를 전송
		log.info(">>>> email >> {}", request.getAttribute("email").toString());
		log.info(">>>> errorMessage >> {}", request.getAttribute("errmsg"));
		re.addFlashAttribute("email", request.getAttribute("email"));
		re.addFlashAttribute("errmsg", request.getAttribute("errmsg"));
		
		return "redirect:/user/login";
	}
	
	@GetMapping("/list")
	public void list (Model m) {
		List<UserVO> userList = usv.getList();
		m.addAttribute("userList", userList);
	}
	
	@GetMapping("/modify")
	public void modify() {
		// user의 email을 이용하여 userVO 객체를 리턴
		// principal 객체 이용해도 됨.
	}
	
	@PostMapping("/modify")
	public String modify(UserVO uvo, RedirectAttributes re, 
			HttpServletRequest request, HttpServletResponse response) {
		log.info(">>>> modify uvo >> {}", uvo);
		int isOk = 0;
		if(uvo.getPwd().isEmpty() || uvo.getPwd().length() == 0) {
			// pwd 가 공백이면 nick_name만 수정
			isOk = usv.modifyPwdEmpty(uvo); 
		}else {
			//pwd가 있다면 pwd를 암호화 하여 저장
			uvo.setPwd(bcEncoder.encode(uvo.getPwd()));
			isOk = usv.modify(uvo);
		}
		//로그아웃을 하고, 수정이 성공되었다 다시 로그인 메시지를 출력
		logout(request, response);
		
		String msg = (isOk > 0)? "ok" : "fail";
		re.addFlashAttribute("modify_msg", msg);
		
		return "redirect:/";
	}
	
	@GetMapping("/remove")
	public String remove(Principal principal, RedirectAttributes re, 
			HttpServletRequest request, HttpServletResponse response) {
		String email = principal.getName();
		int isOk = usv.delete(email);
		
		logout(request, response);
		
		String msg = (isOk > 0)? "ok" : "fail";
		re.addFlashAttribute("remove_msg", msg);
		return "redirect:/";
	}

	//logout 메서드 구현
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		// 내가 로그인한 시큐리티의 authentication 객체 
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		new SecurityContextLogoutHandler().logout(request, response, authentication);
	}
	

}
