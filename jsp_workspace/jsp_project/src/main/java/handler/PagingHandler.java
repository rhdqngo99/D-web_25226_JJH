package handler;

import domain.PagingVO;

public class PagingHandler {
	
	//DB에서는 필요하지 않지만 화면에서 처리가 필요한 경우
	//DB에서 필요한 객체는 domain => VO
	
	// paging 처리에서는 
	// 화면에서 필요한 내용 (페이지네이션 값)  => PagingHandler.class
	// DB 처리에 필요한 내용 limit 번지, 개수 => PagingVO.class
	
	// list 하단에 적은 페이지네이션의 핸들링을 위한 클래스
	private int startPage;  // 현재 화면의 페이지네이션의 시작 번호 1 11 21 31 ...
	private int endPage; // 현재 화면의 페이지네이션의 끝 번호 10 20 30 ...
	private int realEndPage;  // 페이지네이션의 가장 마지막 번호
	private boolean prev; // 이전 페이지의 존재여부
	private boolean next; // 다음 페이지의 존재여부
	
	// 컨트롤러에서 값 받아오기
	private PagingVO pgvo; // 파라미터로 현재 사용자가 클릭한 페이지번호/qty값 받아오기
	private int totalCount; //DB에서 검색해오기
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		// 1 2 3 4 5 6 7 8 9 10 => 1=>10 2=>10 3=>10
		// 1~10 / 11~20 / 21~30 ...
		// pageNo / 10 => 0.1  0.2  0.3 (올림) => 1 * 10 => 10
		// 정수 / 정수 = 정수 (소수점을 살리기 위해 double)
		this.endPage = (int)Math.ceil(this.pgvo.getPageNo()/(double)10)*10;
		this.startPage = this.endPage - 9;
		
		// realEndPage => 전체 게시글 수 / 한 페이지에 표시되는 게시글 수
		// 103  => 103 / 10 => 10.3 => (올림) 11
		// 정수 / 정수 = 정수 (소수점 살리기 위해 double 형변환 필요)
		// 소수점의 값이 남더라도 한 페이지가 더 필요
		this.realEndPage = (int)Math.ceil(this.totalCount / (double)this.pgvo.getQty());
		
		// 실제 리얼마지막 페이지가 11 페이지라면 11페이지가 끝
		// endPage = 20  realEndPage = 11 / endPage가 realEndPage로 변경
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		// 이전, 다음 페이지의 유무
		this.prev = this.startPage > 1;  //1 => 11 21
		this.next = this.endPage < this.realEndPage;
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PagingHandler [startPage=" + startPage + ", endPage=" + endPage + ", realEndPage=" + realEndPage
				+ ", prev=" + prev + ", next=" + next + ", pgvo=" + pgvo + ", totalCount=" + totalCount + "]";
	}
	 
}