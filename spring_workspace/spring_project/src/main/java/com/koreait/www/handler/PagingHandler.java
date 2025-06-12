package com.koreait.www.handler;

import java.util.List;

import com.koreait.www.domain.CommentVO;
import com.koreait.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingHandler {
	
	private int qty; // 한페이지에 나오는 페이지네이션 개수
	private int startPage; // 한페이지에 나오는 페이지네이션의 시작번호
	private int endPage; // 한페이지에 나오는 페이지네이션의 끝번호
	private boolean prev; // 이전 여부
	private boolean next; // 다음 여부
	
	private int totalCount; // 전체 개수 (DB에서 조회 후 매개변수로 받아오기)
	private PagingVO pgvo;  // (매개변수로 받아오기)
	
	private int realEndPage; // 진짜 끝페이지
	
	// 댓글 페이징을 위한 List<CommentVO> 추가
	private List<CommentVO> cmtList;
	
	// 생성자에서 모든 값을 계산
	public PagingHandler(int totalCount, PagingVO pgvo) {
		this.qty = 10;
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		// 1~10 / 11~20 / 21~30 ...
		// pageNo => 1 2 3 ... 10 => 1~10
		// pageNo => 11 12 13... 20 => 11~20
		// pageNo 1,2,3 ... 10 까지는 endPage 변함없이 10
		
		// 1/qty(10) => 0.1 결과를 올림 => 1 * 10 => 10
		// 11 / qty(10) => 1.1 결과를 올림 => 2 * 10 => 20
		// 정수 / 정수 = 정수 이기 때문에 한쪽 형변환 필수
		this.endPage = (int)Math.ceil(pgvo.getPageNo() / (double)this.qty)*this.qty;
		this.startPage = this.endPage - (this.qty-1);
		
		// 실제 마지막 페이지
		// 전체 글수 / 한페이지에 표시되는 게시글 수 (올림)
		// 11 / 10 => 2페이지  1.1 (올림) => 2
		this.realEndPage = (int)Math.ceil(totalCount/(double)pgvo.getQty());
		
		// 이전, 다음 여부
		this.prev = this.startPage > 1;  // 1  11  21  31
		this.next = this.endPage < this.realEndPage; 
		
		if(endPage > realEndPage) {
			this.endPage = realEndPage;
		}
			
	}
	
	// 댓글용 생성자
	public PagingHandler(int totalCount, PagingVO pgvo, List<CommentVO> cmtList) {
		this(totalCount, pgvo);
		this.cmtList = cmtList;
	}
	
}