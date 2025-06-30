package com.example.demo.service;

import com.example.demo.domain.CommentVO;
import com.example.demo.repository.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommentServiceImpl implements CommentService{
    private final CommentMapper commentMapper;

    @Override
    public int post(CommentVO commentVO) {
        return commentMapper.post(commentVO);
    }
}
