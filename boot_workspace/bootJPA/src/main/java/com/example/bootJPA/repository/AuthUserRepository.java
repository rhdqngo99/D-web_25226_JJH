package com.example.bootJPA.repository;

import com.example.bootJPA.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    // id(primary key) => id
    // email을 주고 해당 Email 의 authList
    List<AuthUser> findByEmail (String email);
    void deleteByEmail(String email);
}