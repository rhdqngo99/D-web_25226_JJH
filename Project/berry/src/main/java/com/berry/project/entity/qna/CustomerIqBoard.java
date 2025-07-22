package com.berry.project.entity.qna;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "customeriqboard")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerIqBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(nullable = false)
    private String category;  // 공지 (admin) - 카테고리

    @Column(nullable = false)
    private String title;     // 제목글

    @Column(name = "user_email", nullable = false)
    private String userEmail; // id(메일형식)

    @Lob
    private String content;   // 내용 (TEXT 타입)

    @Column(name = "is_secret")
    private Boolean isSecret; // 비밀글 여부

    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regDate; // 작성 시간

    @Column(name = "mod_date")
    private LocalDateTime modDate; // 수정 시간

    @Column(columnDefinition = "TEXT")
    private String comment;        // 코멘트(답글)

    @Column(name = "comment_reg_date")
    private LocalDateTime commentRegDate; // 코멘트 작성 시간

    @PrePersist
    protected void onCreate() {
        this.regDate = LocalDateTime.now();
        this.modDate = LocalDateTime.now();
    }



    @PreUpdate
    protected void onUpdate() {
        this.modDate = LocalDateTime.now();
    }
}