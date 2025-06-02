package com.koreait.www.service;

import java.util.List;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.PagingVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> getList(PagingVO pagvo);

	BoardVO getDetail(long bno);

	int update(BoardVO bvo);

	int delete(long bno);

	int readCountUp(long bno, int i);

	int getTotalCount(PagingVO pagvo);

}