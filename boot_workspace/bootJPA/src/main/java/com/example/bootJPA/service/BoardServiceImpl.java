package com.example.bootJPA.service;

import com.example.bootJPA.dto.BoardDTO;
import com.example.bootJPA.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    // 저장 객체는 Board
    // save() : 저장
    // entity 객체를 파라미터로 전송
    @Override
    public Long insert(BoardDTO boardDTO) {
        return boardRepository.save(convertDtoToEntity(boardDTO)).getBno();
    }
}
