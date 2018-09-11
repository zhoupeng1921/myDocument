package com.xhx.springboot.converters;


import com.xhx.springboot.enums.BaseEnum;

import javax.persistence.AttributeConverter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractAttributeConverter<T extends Enum & BaseEnum,S> implements AttributeConverter<T, S> {

    private Class<T> clazz;
    private Class<S> codeClazz;
    private Method convertToT;


    public AbstractAttributeConverter(Class<T> clazz,Class<S> codeClazz){
        this.clazz = clazz;
        this.codeClazz = codeClazz;
        try {
            this.convertToT = clazz.getDeclaredMethod("codeToEntity",Class.class,String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    @Override
    public S convertToDatabaseColumn(T attribute) {
        return (S)attribute.getCode();
    }

    @Override
    public T convertToEntityAttribute(S dbData) {
        try {
            return (T)this.convertToT.invoke(null,this.clazz,dbData);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
