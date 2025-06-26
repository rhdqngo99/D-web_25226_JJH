package com.example.bootJPA.repository;

import com.example.bootJPA.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* JpaRepository<엔티티 이름, 기본키 타입> */
public interface FileRepository extends JpaRepository<File, String> {
    // bno에 맞는 FileList 가져오기
    List<File> findByBno(long bno);
}
