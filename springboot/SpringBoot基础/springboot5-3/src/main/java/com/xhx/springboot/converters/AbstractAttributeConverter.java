package com.xhx.springboot.converters;


import com.xhx.springboot.enums.BaseEnum;

import javax.persistence.AttributeConverter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

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
            return Arrays.stream(clazz.getEnumConstants()).filter(en -> en.getCode().equals(dbData)).findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
