package com.example.demo.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {
    private long cno;
    private long bno;
    private String writer;
    private String content;
    private String regDate;
}
