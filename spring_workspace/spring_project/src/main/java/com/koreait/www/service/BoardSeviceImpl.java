package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.repository.BoardDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardSeviceImpl implements BoardService {

	private final BoardDAO bdao;

	@Override
	public int insert(BoardVO bvo) {
		// TODO Auto-generated method stub
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getList(pgvo);
	}

	@Override
	public BoardVO getDetail(long bno) {
		// TODO Auto-generated method stub
		return  bdao.getDetail(bno);
	}
	
	@Transactional
	@Override
	public int update(BoardVO bvo) {
		// TODO Auto-generated method stub
		int isOk = bdao.readCountUp(bvo.getBno(), -1);
		if(isOk > 0) {
			isOk *= bdao.update(bvo);
		}
		return isOk;
	}

	@Override
	public int delete(long bno) {
		// TODO Auto-generated method stub
		return bdao.delete(bno);
	}
	
	@Override
	public int readCountUp(long bno, int i) {
		// TODO Auto-generated method stub
		return bdao.readCountUp(bno, i);
	}
	
	@Override
	public int getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getTotalCount(pgvo);
	}
}