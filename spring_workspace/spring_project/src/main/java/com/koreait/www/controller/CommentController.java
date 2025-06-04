package com.koreait.www.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.www.domain.CommentVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.handler.PagingHandler;
import com.koreait.www.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RequestMapping("/comment/*")
@Slf4j
@RestController
public class CommentController {
	
	private final CommentService csv;
	
	//ResponseEntity<T> : T => response 객체의 body에 보낼 값의 타입
	
	@PostMapping("/post")
	public ResponseEntity<String> post(@RequestBody CommentVO cvo){
		log.info(">>>> cvo >> {}", cvo);
		// cvo를 DB로 전달
		int isOk = csv.post(cvo);
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK) :
			new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 페이지 없을 경우 
//	@GetMapping(value="/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<CommentVO>> list(@PathVariable("bno") long bno){
//		List<CommentVO> list = csv.getList(bno);
//		
//		return new ResponseEntity<List<CommentVO>>(list, HttpStatus.OK);
//	}
	
	@GetMapping(value="/{bno}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PagingHandler> list(
			@PathVariable("bno") long bno, @PathVariable("page")int page){
		
		// DB에서 limit에서 쓸 값을 설정.
		PagingVO pgvo = new PagingVO(page, 5);
//		List<CommentVO> list = csv.getList(bno, pgvo);
//		int totalCount = csv.getTotal(pgvo);
//		PagingHandler ph = new PagingHandler(totalCount, pgvo, list);
		PagingHandler ph = csv.getList(bno, pgvo);
		
		return new ResponseEntity<PagingHandler>(ph, HttpStatus.OK);
	}
	
//	@DeleteMapping("/{cno}")
//	public ResponseEntity<String> delete(@PathVariable("cno") long cno){
//		int isOk = csv.delete(cno);
//		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK) :
//			new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	// @ResponseBody 형태로 변경
	
	@ResponseBody
	@DeleteMapping("/{cno}")
	public String delete(@PathVariable("cno") long cno) {
		int isOk = csv.delete(cno);
		return isOk > 0 ? "1" : "0";
	}

}
