package com.example.bootJPA.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends TimeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increments
    private Long cno;
    @Column(nullable = false)
    private Long bno;
    @Column(length = 200, nullable = false)
    private String writer;
    @Column(length = 1000)
    private String content;
}
