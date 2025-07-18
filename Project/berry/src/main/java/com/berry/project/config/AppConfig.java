package com.berry.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:external-api.properties")
public class AppConfig {
}
