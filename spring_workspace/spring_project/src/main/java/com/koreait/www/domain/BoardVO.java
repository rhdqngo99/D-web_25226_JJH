package com.koreait.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private long bno;
	private String title;
	private String writer;
	private String content;
	private String isDel;
	private String regDate;
	private int readCount;
	private int cmtQty;
	private int fileQty;

}
