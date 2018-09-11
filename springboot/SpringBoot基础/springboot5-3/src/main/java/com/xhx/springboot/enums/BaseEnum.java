package com.xhx.springboot.enums;

import java.util.Arrays;

public interface BaseEnum {

    String getCode();
    String getValue();
    String getDescription();

    static <T extends Enum & BaseEnum> T codeToEntity(Class<T> clazz, String code){
        T[] enums = clazz.getEnumConstants();
        return Arrays.stream(enums).filter(en -> en.getCode().equals(code.trim())).findFirst().get();
    }

}
