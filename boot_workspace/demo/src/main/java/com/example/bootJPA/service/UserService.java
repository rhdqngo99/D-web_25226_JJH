package com.example.bootJPA.service;

import com.example.bootJPA.dto.AuthUserDTO;
import com.example.bootJPA.dto.UserDTO;
import com.example.bootJPA.entity.AuthUser;
import com.example.bootJPA.entity.User;

import java.util.List;

public interface UserService {

    //convert
    //UserDTO -> User
    default User convertDtoToEntity(UserDTO userDTO){
        return User.builder()
                .email(userDTO.getEmail())
                .pwd(userDTO.getPwd())
                .nickName(userDTO.getNickName())
                .lastLogin(userDTO.getLastLogin())
                .build();
    }

    //UserDTO -> authUser
    default AuthUser convertDtoToAuthEntity(UserDTO userDTO){
        return AuthUser.builder()
                .email(userDTO.getEmail())
                .auth("ROLE_USER")
                .build();
    }

    //authUser(entity) -> authUserDTO
    default AuthUserDTO convertEntityToAuthDto(AuthUser authUser){
        return AuthUserDTO.builder()
                .id(authUser.getId())
                .email(authUser.getEmail())
                .auth(authUser.getAuth())
                .build();
    }

    // user(entity) -> userDTO
    default UserDTO convertEntityToDto(User user, List<AuthUserDTO> authUserDTOList){
        return UserDTO.builder()
                .email(user.getEmail())
                .pwd(user.getPwd())
                .nickName(user.getNickName())
                .lastLogin(user.getLastLogin())
                .regDate(user.getRegDate())
                .modDate(user.getModDate())
                .authList(authUserDTOList)
                .build();
    }

    String register(UserDTO userDTO);

    UserDTO selectEmail(String username);

    boolean updateLastLogin(String name);

    String modify(UserDTO userDTO);

    String remove(String name);

    List<UserDTO> getList();
}