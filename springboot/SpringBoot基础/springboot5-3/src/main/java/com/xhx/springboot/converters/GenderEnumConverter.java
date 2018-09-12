package com.xhx.springboot.converters;

import com.xhx.springboot.enums.GenderEnum;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class GenderEnumConverter implements AttributeConverter<GenderEnum,String> {
    @Override
    public String convertToDatabaseColumn(GenderEnum genderEnum) {
        return genderEnum.getCode();
    }

    @Override
    public GenderEnum convertToEntityAttribute(String s) {
        return Arrays.stream(GenderEnum.values()).filter(en -> en.getCode().equals(s)).findFirst().orElse(null);
    }
}
