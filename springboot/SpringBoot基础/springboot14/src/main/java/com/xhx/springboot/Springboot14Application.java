package com.xhx.springboot;

import com.xhx.springboot.config.FileConfig;
import javafx.scene.chart.ValueAxis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:file.properties"})
@EnableConfigurationProperties(value = {FileConfig.class})
public class Springboot14Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot14Application.class, args);
    }
}
