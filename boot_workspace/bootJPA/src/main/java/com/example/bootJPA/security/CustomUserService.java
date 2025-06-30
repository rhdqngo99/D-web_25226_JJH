package com.example.bootJPA.security;

import com.example.bootJPA.dto.UserDTO;
import com.example.bootJPA.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class CustomUserService implements UserDetailsService {

    @Autowired
    public UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // security context 객체가 username을 주고 해당 객체의 값을
        // DB에서 가져와 UserDetails 객체로 리턴
        UserDTO userDTO = userService.selectEmail(username);
        log.info(">>>> UserDetails login User >> {}", userDTO);
        if(userDTO == null){
            throw new UsernameNotFoundException(username);
        }
        return new AuthMember(userDTO);
    }
}