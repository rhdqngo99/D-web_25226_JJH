package com.example.bootJPA.repository;

/* JpaRepository<테이블명, id> */

import com.example.bootJPA.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
