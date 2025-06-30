package com.example.bootJPA.service;

import com.example.bootJPA.dto.UserDTO;
import com.example.bootJPA.entity.AuthUser;
import com.example.bootJPA.entity.User;
import com.example.bootJPA.repository.AuthUserRepository;
import com.example.bootJPA.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final AuthUserRepository authUserRepository;

    @Override
    public String register(UserDTO userDTO) {
        String email = userRepository.save(convertDtoToEntity(userDTO)).getEmail();
        if(email != null){
            authUserRepository.save(convertDtoToAuthEntity(userDTO));
        }
        return email;
    }

    @Override
    public UserDTO selectEmail(String username) {
        // 찾는 검색값이 id 가 아닌 경우 해당 repository에 등록 후 사용
        // findBy~  select * from table where 값
        Optional<User> optional = userRepository.findById(username);
        List<AuthUser> userList = authUserRepository.findByEmail(username);
        if(optional.isPresent()){
            UserDTO userDTO = convertEntityToDto(optional.get(),
                    userList.stream()
                            .map(this::convertEntityToAuthDto)
                            .toList()
            );
            return userDTO;
        }
        // optional 값이 없으면 null 리턴
        return null;
    }

    @Transactional
    @Override
    public boolean updateLastLogin(String name) {
        Optional<User> optional = userRepository.findById(name);
        if(optional.isPresent()){
            User user = optional.get();
            // 현재날짜로 값을 변경 : LocalDateTime.now()
            user.setLastLogin(LocalDateTime.now());
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public String modify(UserDTO userDTO) {
        Optional<User> optional = userRepository.findById(userDTO.getEmail());
        if(optional.isPresent()){
            User user = optional.get();
            if(userDTO.getPwd().length()>0){
                user.setPwd(userDTO.getPwd());
            }
            user.setNickName(userDTO.getNickName());
            return user.getEmail();
        }
        return null;
    }

    @Transactional
    @Override
    public String remove(String name) {
        Optional<User> optional = userRepository.findById(name);
        if (optional.isPresent()){
            userRepository.deleteById(name);
            // 권한 삭제도 같이 deleteByEmail
            authUserRepository.deleteByEmail(name);
            return name;
        }
        return null;
    }

    @Override
    public List<UserDTO> getList() {
        // user => findAll
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : userList){
            List<AuthUser> authUserList =
                    authUserRepository.findByEmail(user.getEmail());
            UserDTO userDTO = convertEntityToDto(user,
                    authUserList.stream()
                            .map(this :: convertEntityToAuthDto)
                            .toList());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}