package com.example.bootJPA.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String email;
    private String pwd;
    private String nickName;
    private LocalDateTime lastLogin, regDate, modDate;
    private List<AuthUserDTO> authList;
}