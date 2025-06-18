package com.example.demo.service;

import com.example.demo.domain.BoardVO;
import com.example.demo.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    @Override
    public void register(BoardVO boardVO) {
        boardMapper.register(boardVO);
    }

    @Override
    public List<BoardVO> getList() {
        return boardMapper.getList();
    }

    @Override
    public BoardVO getDetail(long bno) {
        return boardMapper.getDetail(bno);
    }

    @Override
    public void delete(long bno) {
        boardMapper.delete(bno);
    }

    @Override
    public void update(BoardVO boardVO) {
        boardMapper.update(boardVO);
    }
}
