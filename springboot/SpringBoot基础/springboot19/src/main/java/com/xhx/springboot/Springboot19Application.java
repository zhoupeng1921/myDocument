package com.xhx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//mvn package docker:build -e
@SpringBootApplication
public class Springboot19Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot19Application.class, args);
    }
}
