package com.koreait.www.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {
	
	// 생성자 주입 시 @RequiredArgsConstructor => final
	private final BoardService bsv;
	
	// servlet path case => method 형식으로 사용
	// return 타입이 가야하는 주소 타입 설정
	
	// /board/register => jsp에서 controller로 오는 경로
	// 리턴 주소와 (jsp 파일 경로) = request 주소 경로가 같은경우 생략가능
	
//	@GetMapping("/register")
//	public String register() {
//		return "/board/register";
//	}
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/insert")
	public String insert(BoardVO bvo) {
		log.info(">>>> bvo >> {}", bvo);
		int isOk = bsv.insert(bvo);
		log.info(">>>> insert isOk >> {}", (isOk>0)? "ok":"fail");
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(Model m) {
		List<BoardVO> list = bsv.getList();
		// 가져온 리스트 /board/list.jsp로 전달
		m.addAttribute("list", list);
	}
}