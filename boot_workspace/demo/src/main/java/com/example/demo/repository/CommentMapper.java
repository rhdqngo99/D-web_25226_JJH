package com.example.demo.repository;

import com.example.demo.domain.CommentVO;
import com.example.demo.domain.PagingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    int post(CommentVO commentVO);

    int getTotalCount(long bno);

    List<CommentVO> getCommentByBno(@Param("bno") long bno, @Param("pagingVO") PagingVO pagingVO);

    int update(CommentVO commentVO);

    int remove(long cno);
}
