package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.www.domain.BoardVO;
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
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return bdao.getList();
	}
	
}