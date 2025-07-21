package com.berry.project.service;

import com.berry.project.dto.CustomerIqBoardDTO;
import com.berry.project.dto.CustomerIqBoardFileDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class CustomerIqBoardServiceImpl implements CustomerIqBoardService {

  @Override
  public List<CustomerIqBoardDTO> getList() {
    return List.of();
  }

  @Override
  public Page<CustomerIqBoardDTO> getPageList(int pageNo) {
    return null;
  }

  @Override
  public CustomerIqBoardFileDTO getDetail(Long bno) {
    return null;
  }

  @Override
  public Long modify(CustomerIqBoardFileDTO boardFileDTO) {
    return 0L;
  }

  @Override
  public void remove(Long bno) {

  }

  @Override
  public Page<CustomerIqBoardDTO> getList(int pageNo, String type, String keyword) {
    return null;
  }

  @Override
  public long fileRemove(String uuid) {
    return 0;
  }

  @Override
  public Long insertBoard(CustomerIqBoardDTO customerIqBoardDTO) {
    return 0L;
  }

  @Override
  public Long insertFile(CustomerIqBoardFileDTO customerIqBoardFileDTO) {
    return 0L;
  }

}