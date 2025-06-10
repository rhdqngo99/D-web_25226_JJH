package com.koreait.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
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

}
