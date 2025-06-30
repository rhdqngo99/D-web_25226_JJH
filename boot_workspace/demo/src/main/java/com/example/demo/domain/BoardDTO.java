package com.example.demo.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private BoardVO boardVO;
    private List<FileVO> fileList;
}
