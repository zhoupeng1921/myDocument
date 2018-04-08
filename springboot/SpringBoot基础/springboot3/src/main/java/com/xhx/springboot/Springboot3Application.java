package com.xhx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * spring.profile.active两种用法   1.用于配置文件,不同环境加载不同配置文件  2.用注解,不同环境执行不同类或者方法
 */
@SpringBootApplication
public class Springboot3Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3Application.class, args);
	}


}
