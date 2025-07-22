package com.berry.project.repository;

import com.berry.project.entity.qna.CustomerIqBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerIqBoardRepository extends JpaRepository<CustomerIqBoard, Long>{
}
