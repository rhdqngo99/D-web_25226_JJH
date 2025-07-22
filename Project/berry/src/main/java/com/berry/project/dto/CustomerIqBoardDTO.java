package com.berry.project.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerIqBoardDTO {

  private Long bno;
  private String title;
  private String userEmail;
  private String content;
  private int readCount;
  private int cmtQty;
  private int fileQty;
  private LocalDateTime regDate,modDate;

}