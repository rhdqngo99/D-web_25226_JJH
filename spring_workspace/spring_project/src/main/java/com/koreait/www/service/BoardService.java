package com.koreait.www.service;

import java.util.List;

import com.koreait.www.domain.BoardVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> getList();

}
