package com.xhx.springboot.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * xuhaixing
 * 2018/5/19 10:54
 */
@ConfigurationProperties(prefix = "file")
public class FileConfig {
    private String uploadLocation;

    public String getUploadLocation() {
        return uploadLocation;
    }

    public void setUploadLocation(String uploadLocation) {
        this.uploadLocation = uploadLocation;
    }
}
