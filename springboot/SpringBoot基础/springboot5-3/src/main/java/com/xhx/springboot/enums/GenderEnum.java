package com.xhx.springboot.enums;

import com.xhx.springboot.converters.AbstractAttributeConverter;

public enum GenderEnum implements BaseEnum<GenderEnum,String>{
    MAN("1","男"),WOMAN("2","女");
    GenderEnum(String code,String value){
        this.code = code;
        this.value = value;
    }
    private String code;
    private String value;
    private String description;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public static class convert extends AbstractAttributeConverter<GenderEnum,String>{
        public convert(){
            super(GenderEnum.class,String.class);
        }
    }
}