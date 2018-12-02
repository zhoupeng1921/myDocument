package com.xhx.springboot.converters;

import com.xhx.springboot.enums.GenderEnum;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Objects;

public class GenderEnumConverter implements AttributeConverter<GenderEnum,String> {
    @Override
    public String convertToDatabaseColumn(GenderEnum genderEnum) {
        return genderEnum.getCode();
    }

    @Override
    public GenderEnum convertToEntityAttribute(String s) {
        return Arrays.stream(GenderEnum.values()).filter(en -> Objects.equals(en.getCode(),s)).findFirst().get();
    }
}
