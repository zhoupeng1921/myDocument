package com.xhx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync //开启异步线程
@EnableScheduling
public class Springboot18Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot18Application.class, args);
	}
}
