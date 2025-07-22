package com.berry.project.service;

import com.berry.project.dto.CustomerIqBoardDTO;
import com.berry.project.entity.qna.CustomerIqBoard;
import com.berry.project.repository.CustomerIqBoardRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerIqBoardServiceImpl implements CustomerIqBoardService {

  private final CustomerIqBoardRepository customerIqBoardRepository;

  public CustomerIqBoardServiceImpl(CustomerIqBoardRepository customerIqBoardRepository) {
    this.customerIqBoardRepository = customerIqBoardRepository;
  }

  @Override
  public CustomerIqBoardDTO create(CustomerIqBoardDTO request) {

    CustomerIqBoard entity = CustomerIqBoard.builder()
        .title(request.getTitle())
        .userEmail(request.getUserEmail())
        .content(request.getContent())
        .build();

    CustomerIqBoard saved = customerIqBoardRepository.save(entity);

    return CustomerIqBoardDTO.builder()
        .bno(saved.getBno())
        .title(saved.getTitle())
        .userEmail(saved.getUserEmail())
        .content(saved.getContent())
        .regDate(saved.getRegDate())
        .modDate(saved.getModDate())
        .build();
  }

//  @Override
//  public Long insert(CustomerIqBoardFileDTO customerIqboardFileDTO) {
//    return 0L;
//  }
//
//  @Override
//  public Long insert(CustomerIqBoardDTO customerIqboardDTO) {
//    return 0L;
//  }
//
//  @Override
//  public List<CustomerIqBoardDTO> getList() {
//    return List.of();
//  }
//
//  @Override
//  public Page<CustomerIqBoardDTO> getPageList(int pageNo) {
//    return null;
//  }
//
//  @Override
//  public CustomerIqBoardFileDTO getDetail(Long bno) {
//    return null;
//  }
//
//  @Override
//  public Long modify(CustomerIqBoardFileDTO boardFileDTO) {
//    return 0L;
//  }
//
//  @Override
//  public void remove(Long bno) {
//
//  }
//
//  @Override
//  public Page<CustomerIqBoardDTO> getList(int pageNo, String type, String keyword) {
//    return null;
//  }
//
//  @Override
//  public long fileRemove(String uuid) {
//    return 0;
//  }

//  @Override
//  public Long insertBoard(CustomerIqBoardDTO customerIqBoardDTO) {
//    return 0L;
//  }
//
//  @Override
//  public Long insertFile(CustomerIqBoardFileDTO customerIqBoardFileDTO) {
//    return 0L;
//  }

}