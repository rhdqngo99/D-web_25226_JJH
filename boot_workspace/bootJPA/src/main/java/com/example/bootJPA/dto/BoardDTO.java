package com.example.bootJPA.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
    private Long bno;
    private String title;
    private String writer;
    private String content;
    private int readCount;
    private int cmtQty;
    private int fileQty;
    private LocalDateTime regDate, modDate;
}