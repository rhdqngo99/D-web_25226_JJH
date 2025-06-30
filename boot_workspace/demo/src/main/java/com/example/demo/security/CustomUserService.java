package com.example.demo.security;

import com.example.demo.domain.UserVO;
import com.example.demo.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //username을 주고 해당 유저의 객체를 리턴받기
        UserVO userVO = userMapper.selectUser(username);
        userVO.setAuthList(userMapper.selectAuths(username));

        //return UserDetails 객체
        return new AuthUser(userVO);
    }
}
