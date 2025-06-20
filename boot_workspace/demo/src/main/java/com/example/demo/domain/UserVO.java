package com.example.demo.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String email;
    private String pwd;
    private String nickName;
    private String regDate;
    private String lastLogin;
    private List<AuthVO> authList;
}