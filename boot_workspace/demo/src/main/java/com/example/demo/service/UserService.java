package com.example.demo.service;

import com.example.demo.domain.UserVO;

import java.util.List;

public interface UserService {
    void insert(UserVO userVO);

    List<UserVO> getList();

    void remove(String name);

    void modify(UserVO userVO);

    void modifyNoPwd(UserVO userVO);
}
