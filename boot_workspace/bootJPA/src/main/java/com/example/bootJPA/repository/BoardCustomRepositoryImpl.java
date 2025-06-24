package com.example.bootJPA.repository;

import com.example.bootJPA.entity.Board;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory queryFactory;

    public BoardCustomRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    // 실제 구현
    @Override
    public Page<Board> searchBoard(String type, String keyword, Pageable pageable) {
        /* BooleanExpression : 일반적으로 동적쿼리를 작성할 때 사용하는 객체 */
        return null;
    }

}
