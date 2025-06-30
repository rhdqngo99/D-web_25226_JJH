package com.example.bootJPA.repository;

import com.example.bootJPA.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardCustomRepository {
    /* type, keyword, pageable을 주고, Page<Board> 를 리턴받는 메서드를 생성 */
    Page<Board> searchBoard(String type, String keyword, Pageable pageable);
}