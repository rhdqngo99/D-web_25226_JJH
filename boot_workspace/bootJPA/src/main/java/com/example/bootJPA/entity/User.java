package com.example.bootJPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User extends TimeBase{
    @Id
    private String email;
    @Column(nullable = false)
    private String pwd;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

}