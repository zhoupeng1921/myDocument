package com.xhx.springboot.enums;

import java.util.Arrays;
import java.util.Objects;

public interface BaseEnum<T extends Enum & BaseEnum,S> {

    S getCode();
    String getValue();
    String getDescription();

    default  BaseEnum codeToEntity(S code){
        BaseEnum[] enums = this.getClass().getEnumConstants();
        return Arrays.stream(enums).filter(en -> Objects.equals(en.getCode(),code)).findFirst().get();
    }

}
