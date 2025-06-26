package com.example.bootJPA.repository;

import com.example.bootJPA.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository<entity name, id class> */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //List<Comment> findByBno(long bno); // page 없을 경우
    Page<Comment> findByBno(long bno, Pageable pageable);
}