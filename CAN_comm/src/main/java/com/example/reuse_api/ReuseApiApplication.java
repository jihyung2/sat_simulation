package com.example.reuse_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.reuse_api.repository")
@EntityScan(basePackages = "com.example.reuse_api.entity")// 엔티티 클래스의 패키지 경로 지정
public class ReuseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReuseApiApplication.class, args);
    }

}
