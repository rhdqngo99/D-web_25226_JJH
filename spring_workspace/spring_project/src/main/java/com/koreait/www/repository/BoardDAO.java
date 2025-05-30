package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.BoardVO;

public interface BoardDAO {
	// BoardDAOImpl = mapper (namespace.id)
	// namespace : BoardDAO의 경로 com.koreait.www.repository.BoardDAO
	// id : 메서드명
	
	int insert(BoardVO bvo);

	List<BoardVO> getList();
	
}