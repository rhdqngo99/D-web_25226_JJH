package com.example.demo.repository;

import com.example.demo.domain.AuthVO;
import com.example.demo.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(UserVO userVO);

    void authInsert(String email);

    UserVO selectUser(String username);

    List<AuthVO> selectAuths(String username);

    List<UserVO> getList();

    void removeAuths(String name);

    void remove(String name);

    void modify(UserVO userVO);

    void modifyNoPwd(UserVO userVO);
}
