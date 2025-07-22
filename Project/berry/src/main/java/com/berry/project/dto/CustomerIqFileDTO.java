package com.berry.project.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerIqFileDTO {

  private String uuid;
  private String saveDir;
  private String fileName;
  private int fileType;
  private long bno;
  private long fileSize;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

}

