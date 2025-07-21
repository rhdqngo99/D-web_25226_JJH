package com.berry.project.service;

import com.berry.project.dto.CustomerIqBoardDTO;
import com.berry.project.dto.CustomerIqBoardFileDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerIqBoardService {

  List<CustomerIqBoardDTO> getList();

  Page<CustomerIqBoardDTO> getPageList(int pageNo);

  CustomerIqBoardFileDTO getDetail(Long bno);

  Long modify(CustomerIqBoardFileDTO boardFileDTO);

  void remove(Long bno);

  Page<CustomerIqBoardDTO> getList(int pageNo, String type, String keyword);

  long fileRemove(String uuid);
  // 게시글 등록
  Long insertBoard(CustomerIqBoardDTO customerIqBoardDTO);

  // 파일 등록
  Long insertFile(CustomerIqBoardFileDTO customerIqBoardFileDTO);
}