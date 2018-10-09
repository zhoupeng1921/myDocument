package com.xhx.spring.enums;/*
 * xuhai
 * 2018/10/8 21:59
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;

//把enum类型转换为json输出到前端，否则会输出name
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GenderEnum {

    MAN(0,"MAN","男"),WOMAN(1,"WOMAN","女");

    GenderEnum(int code, String value, String desc){
        this.code = code;
        this.value = value;
        this.desc = desc;
    }
    private int code;
    private String value;
    private String desc;


    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static GenderEnum fromString(String value){
        GenderEnum gender = Arrays.stream(GenderEnum.values()).filter(genderEnum -> genderEnum.getValue().equalsIgnoreCase(value)).findFirst().orElse(null);
        return gender;
    }
}
