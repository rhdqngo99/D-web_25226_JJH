package com.koreait.www.service;

import java.util.List;

import com.koreait.www.domain.BoardDTO;
import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.FileVO;
import com.koreait.www.domain.PagingVO;

public interface BoardService {

	int insert(BoardDTO bdto);

	List<BoardVO> getList(PagingVO pgvo);

	BoardDTO getDetail(long bno);

	int update(BoardDTO boardDTO);

	int delete(long bno);

	int readCountUp(long bno, int i);

	int getTotalCount(PagingVO pgvo);

	int removeFile(String uuid);

	FileVO getFile(String uuid);

}