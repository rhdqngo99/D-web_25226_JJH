package com.example.bootJPA.service;

import com.example.bootJPA.dto.CommentDTO;
import com.example.bootJPA.entity.Comment;
import org.springframework.data.domain.Page;

public interface CommentService {
    /* convert */
    // DTO => entity
    default Comment convertDtoToEntity(CommentDTO commentDTO){
        return Comment.builder()
                .cno(commentDTO.getCno())
                .bno(commentDTO.getBno())
                .writer(commentDTO.getWriter())
                .content(commentDTO.getContent())
                .build();
    }

    // entity => DTO
    default CommentDTO convertEntityToDto(Comment comment){
        return CommentDTO.builder()
                .cno(comment.getCno())
                .bno(comment.getBno())
                .writer(comment.getWriter())
                .content(comment.getContent())
                .regDate(comment.getRegDate())
                .modDate(comment.getModDate())
                .build();
    }

    long post(CommentDTO commentDTO);

    // List<CommentDTO> getList(Long bno);  // page 없을 때 사용

    Page<CommentDTO> getList(Long bno, int page);

    Long remove(long cno);

    Long modify(CommentDTO commentDTO);
}
