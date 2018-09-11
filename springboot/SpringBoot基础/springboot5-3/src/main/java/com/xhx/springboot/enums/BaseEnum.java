package com.xhx.springboot.enums;

import java.util.Arrays;

public interface BaseEnum<T extends Enum & BaseEnum,S> {

    S getCode();
    String getValue();
    String getDescription();

    default  T codeToEntity(Class<T> clazz, S code){
        T[] enums = clazz.getEnumConstants();
        return Arrays.stream(enums).filter(en -> en.getCode().equals(code)).findFirst().get();
    }

}
