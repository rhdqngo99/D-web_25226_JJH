package com.example.demo.service;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;
import com.example.demo.domain.PagingVO;

import java.util.List;

public interface BoardService {

    void register(BoardDTO boardDTO);

    List<BoardVO> getList(PagingVO pagingVO);

    BoardDTO getDetail(long bno);

    void delete(long bno);

    void update(BoardDTO boardVO);

    int getTotalCount(PagingVO pagingVO);

    int fileDelete(String uuid);

    FileVO getFile(String uuid);
}