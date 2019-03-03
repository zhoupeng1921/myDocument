package com.xhx.springboot.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
//          SpringApplication.run(BannerApplication.class, args);
        SpringApplication app = new SpringApplication(BannerApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);

    }
}
