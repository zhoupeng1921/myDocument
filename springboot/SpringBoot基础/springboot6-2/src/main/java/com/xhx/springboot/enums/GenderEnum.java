package com.xhx.springboot.enums;

public enum  GenderEnum {
    MAN("0","男"),WOMAN("1","女");

    GenderEnum(String code,String value){
        this.code = code;
        this.value = value;
    }
    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "GenderEnum{" +
                "code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
