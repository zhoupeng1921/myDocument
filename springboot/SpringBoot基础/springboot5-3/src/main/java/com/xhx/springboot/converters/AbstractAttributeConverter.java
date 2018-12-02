package com.xhx.springboot.converters;


import com.xhx.springboot.enums.BaseEnum;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Objects;

//抽象出来转换db->entity转换类
public abstract class AbstractAttributeConverter<T extends Enum & BaseEnum<T,S>,S> implements AttributeConverter<T, S> {

    private Class<T> clazz;
    private Class<S> codeClazz;


    public AbstractAttributeConverter(Class<T> clazz,Class<S> codeClazz){
        this.clazz = clazz;
        this.codeClazz = codeClazz;
    }


    @Override
    public S convertToDatabaseColumn(T attribute) {
        return attribute.getCode();
    }

    @Override
    public T convertToEntityAttribute(S dbData) {
        try {
            return Arrays.stream(clazz.getEnumConstants()).filter(en -> Objects.equals(en.getCode(),dbData)).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
