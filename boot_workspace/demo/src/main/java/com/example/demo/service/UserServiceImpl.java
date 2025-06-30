package com.example.demo.service;

import com.example.demo.domain.UserVO;
import com.example.demo.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;

    @Transactional
    @Override
    public void insert(UserVO userVO) {
        userMapper.insert(userVO);
        userMapper.authInsert(userVO.getEmail());
    }

    @Transactional
    @Override
    public List<UserVO> getList() {
        List<UserVO> userList = userMapper.getList();
        for(UserVO userVO : userList){
            userVO.setAuthList(userMapper.selectAuths(userVO.getEmail()));
        }
        return userList;
    }

    @Transactional
    @Override
    public void remove(String name) {
        userMapper.removeAuths(name);
        userMapper.remove(name);
    }

    @Override
    public void modify(UserVO userVO) {
        userMapper.modify(userVO);
    }

    @Override
    public void modifyNoPwd(UserVO userVO) {
        userMapper.modifyNoPwd(userVO);
    }
}