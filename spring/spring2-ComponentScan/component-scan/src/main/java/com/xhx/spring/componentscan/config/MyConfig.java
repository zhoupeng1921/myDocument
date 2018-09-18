package com.xhx.spring.componentscan.config;

import com.xhx.spring.controller.HelloController;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * xuhaixing
 * 2018/9/18 22:20
 **/
@Configuration
@ComponentScan(value = "com.xhx.spring",
        useDefaultFilters = false,
        includeFilters = {
            @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        }
)
public class MyConfig {
}
