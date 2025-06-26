package com.example.bootJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/* jps 사용시 필수 어노테이션 */
@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication
public class BootJpaApplication {

	public static void main(String[] args) {

		SpringApplication.run(BootJpaApplication.class, args);
	}

}