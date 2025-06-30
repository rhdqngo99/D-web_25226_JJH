package com.example.bootJPA.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "auth_user")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String auth;
}
