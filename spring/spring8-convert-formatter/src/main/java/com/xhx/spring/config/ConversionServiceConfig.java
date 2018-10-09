package com.xhx.spring.config;/*
 * xuhai
 * 2018/10/8 22:14
 */

import com.xhx.spring.converters.EnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

@Configuration
public class ConversionServiceConfig {


    public ConversionServiceConfig(ConversionService conversionService){
        ((DefaultFormattingConversionService)conversionService).addConverter(new EnumConverter());
    }
}
