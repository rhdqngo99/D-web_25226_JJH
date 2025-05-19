package board;

import java.util.Date;
import java.util.Objects;

public class Board {
	/* 번호, 제목, 내용, 작성자, 작성일
	 * 번호가 일치하면 같은 게시물로 인지 => equals 추가
	 * - 각 객체는 독립적 / 번호는 하나의 번호를 참조
	 * 번호는 자동으로 증가 => static (전 객체가 공유)
	 * 작성일은 오늘날짜를 자동으로 추가
	 * */
	private static int count;  //자동증가 카운트
	private int num;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	
	// 생성자
	public Board() {
		count++; //번호 증가
		num = count; 
		// Date
		this.regDate = new Date();
	}
	public Board(String title, String content, String writer) {
		this(); //생성자 호출 
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public Board(int num) {
		this.num = num;
	}
	
	public void print() {
		// 하나의 게시글을 예쁘게(상세) 보여주는 메서드
		System.out.println("num:"+getNum());
		System.out.println("title:"+this.title);
		System.out.println("writer:"+this.writer);
		System.out.println("regDate:"+this.regDate);
		System.out.println("content:");
		System.out.println(content);
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", writer=" + writer + ", regDate="
				+ regDate + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return num == other.num;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	

}