package com.example.demo.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthVO {
    private int id;
    private String email;
    private String auth;
}
