package com.inf.khproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KhprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhprojectApplication.class, args);
    }

}
