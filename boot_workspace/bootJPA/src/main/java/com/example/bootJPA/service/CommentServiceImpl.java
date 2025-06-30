package com.example.bootJPA.service;

import com.example.bootJPA.dto.CommentDTO;
import com.example.bootJPA.entity.Board;
import com.example.bootJPA.entity.Comment;
import com.example.bootJPA.repository.BoardRepository;
import com.example.bootJPA.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public long post(CommentDTO commentDTO) {
        // 저장 대상은 Comment, CommentDTO 를 Comment로 변환
        // save()
        Optional<Board> optional = boardRepository.findById(commentDTO.getBno());
        if(optional.isPresent()){
            Board board = optional.get();
            board.setCmtQty(board.getCmtQty()+1);
        }
        return commentRepository.save(convertDtoToEntity(commentDTO)).getCno();
    }

    @Override
    public Page<CommentDTO> getList(Long bno, int page) {
        // select * from comment where bno = #{bno} limit page, 5;
        Pageable pageable = PageRequest.of(page, 5, Sort.by("cno").descending());
        Page<Comment> list = commentRepository.findByBno(bno, pageable);
        return list.map(this::convertEntityToDto);
        // List<Comment> list = commentRepository.findByBno(bno);
        // return list.stream().map(this::convertEntityToDto).toList();

    }

    @Transactional
    @Override
    public Long remove(long cno) {
        Optional<Comment> optional = commentRepository.findById(cno);
        if(optional.isPresent()){
            Optional<Board> optionalBoard = boardRepository.findById(optional.get().getBno());
            if(optionalBoard.isPresent()){
                Board board = optionalBoard.get();
                board.setCmtQty(board.getCmtQty()-1);
            }
            commentRepository.deleteById(cno);
            return cno;
        }
        return null;
    }

    @Override
    public Long modify(CommentDTO commentDTO) {
        Optional<Comment> optional = commentRepository.findById(commentDTO.getCno());
        if(optional.isPresent()){
            Comment comment = optional.get();
            comment.setContent(commentDTO.getContent());
            return commentRepository.save(comment).getCno();
        }
        return 0L;
    }
}