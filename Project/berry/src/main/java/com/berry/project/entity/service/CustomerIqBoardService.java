package com.berry.project.entity.service;

import com.berry.project.entity.dto.CustomerIqBoardDTO;

import java.util.List;

public interface CustomerIqBoardService {

    CustomerIqBoardDTO.Response create(CustomerIqBoardDTO.Request request);

    List<CustomerIqBoardDTO.Response> list();

    CustomerIqBoardDTO.Response detail(Long bno);

    CustomerIqBoardDTO.Response update(Long bno, CustomerIqBoardDTO.Request request);

    void delete(Long bno);

    CustomerIqBoardDTO.Response addOrUpdateComment(Long bno, String comment);
}