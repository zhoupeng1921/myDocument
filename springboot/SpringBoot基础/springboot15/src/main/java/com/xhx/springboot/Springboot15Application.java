package com.xhx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springboot15Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot15Application.class, args);
    }
}
