package com.berry.project.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerIqBoardFileDTO {

  private CustomerIqBoardDTO boardDTO;
  private List<CustomerIqFileDTO> fileList;
}
