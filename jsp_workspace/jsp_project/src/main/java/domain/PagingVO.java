package domain;

public class PagingVO {
	
	// 페이지처리를 위해 DB에서 필요한 객체를 만들어줌.
	// 전체 게시글에서 0번지부터 10개의 값을 출력
	// select * from board order by bno desc limit 0, 10;
	// limit 번지, 개수
	// 번지는 0번지부터 시작 => 계산해서 리턴
	
	private int pageNo; // 페이지 번호 (하단 페이지네이션 값)
	private int qty; // 한페이지에 표시되는 게시글 수 (10개)
	
	// 검색에 필요한 변수를 추가
	private String type;
	private String keyword;
	
	public PagingVO() {
		// 페이징의 값이 없다면 무조건 1페이지
		this.pageNo = 1;
		this.qty = 10;
	}
	
	public PagingVO(int pageNo, int qty, String type, String keyword) {
		this.pageNo = pageNo;
		this.qty = qty;
		this.type = type;
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	// 시작번지 계산 (페이지에 따라서 달라짐)
	// 1 => 0 / 2=> 10 / 3=> 20 ...
	public int getPageStart() {
		return (this.pageNo -1) * this.qty;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "PagingVO [pageNo=" + pageNo + ", qty=" + qty + ", type=" + type + ", keyword=" + keyword + "]";
	}

}
