package com.xhx.springboot.utils;

import java.util.List;

/**
 * xuhaixing
 * 2018/9/20 21:31
 **/
public class Condition<T,R> {
    private Class<T> clazz;
    private String field;
    private OperatorEnum operator;
    private List<R> data;

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public OperatorEnum getOperator() {
        return operator;
    }

    public void setOperator(OperatorEnum operator) {
        this.operator = operator;
    }

    public List<R> getData() {
        return data;
    }

    public void setData(List<R> data) {
        this.data = data;
    }
}
