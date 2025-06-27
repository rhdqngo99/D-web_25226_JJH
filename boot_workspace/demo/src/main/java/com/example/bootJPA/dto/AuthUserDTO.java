package com.example.bootJPA.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUserDTO {
    private Long id;
    private String email;
    private String auth;
}