package com.koreait.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.PagingVO;

public interface BoardDAO {
	// BoardDAOImpl => mapper (namespace.id)
	// namespace : BoardDAO의 경로 com.koreait.www.repository.BoardDAO
	// id : 메서드명

	int insert(BoardVO bvo);

	List<BoardVO> getList(PagingVO pgvo);

	BoardVO getDetail(long bno);

	int update(BoardVO bvo);

	int delete(long bno);

	int readCountUp(@Param("bno") long bno, @Param("i") int i);

	int getTotalCount(PagingVO pgvo);

	long getBno();
	
	

}