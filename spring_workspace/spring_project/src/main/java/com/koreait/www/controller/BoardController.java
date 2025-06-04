package com.koreait.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.handler.PagingHandler;
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
	public void list(Model m, PagingVO pgvo) {
		//PagingVO pgvo = new PagingVO(); // 1, 10 => 0,10
		List<BoardVO> list = bsv.getList(pgvo);
		// totalCount 구해오기
		int totalCount = bsv.getTotalCount(pgvo);
		PagingHandler ph = new PagingHandler(totalCount, pgvo);
		log.info(">>>> ph >> {}", ph);
		// 가져온 리스트 /board/list.jsp로 전달
		m.addAttribute("ph", ph);
		m.addAttribute("list", list);
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("bno")long bno, Model m, HttpServletRequest request) {
		String path = request.getServletPath();
		log.info(">>>> uri >> {}", request.getServletPath()); // /board/detail
		if(path.equals("/board/detail")) {
			// readCountUp +1
			int isOk = bsv.readCountUp(bno, 1);
		}
		BoardVO bvo = bsv.getDetail(bno);
		m.addAttribute("bvo", bvo);
	}
	
	// RedirectAttributes
	@PostMapping("/update")
	public String update(BoardVO bvo, RedirectAttributes re) {
		int isOk = bsv.update(bvo);
		re.addAttribute("bno", bvo.getBno());
		return "redirect:/board/detail";
		//return "redirect:/board/detail?bno="+bvo.getBno();
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno")int bno) {
		int isOk = bsv.delete(bno);
		return "redirect:/board/list";
	}
	
}