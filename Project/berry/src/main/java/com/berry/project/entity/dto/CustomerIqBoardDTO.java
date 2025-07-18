package com.berry.project.entity.dto;

import lombok.*;
import java.time.LocalDateTime;

public class CustomerIqBoardDTO {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private String category;
        private String title;
        private String userEmail;
        private String content;
        private Boolean isSecret;
        private String comment;  // 답글(관리자용)
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long bno;
        private String category;
        private String title;
        private String userEmail;
        private String content;
        private Boolean isSecret;
        private String comment;
        private LocalDateTime regDate;
        private LocalDateTime modDate;
        private LocalDateTime commentRegDate;
    }
}
