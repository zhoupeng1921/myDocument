package com.xhx.spring.converters;/*
 * xuhai
 * 2018/10/8 21:58
 */

import com.xhx.spring.enums.GenderEnum;
import org.springframework.core.convert.converter.Converter;

public class EnumConverter implements Converter<String, GenderEnum> {
    @Override
    public GenderEnum convert(String source) {
        return GenderEnum.fromString(source);
    }
}
