package com.xhx.springboot.utils;

/**
 * xuhaixing
 * 2018/9/20 21:31
 **/
public class Condition<T> {
    private Class<T> clazz;
    private String field;
    private OperatorEnum operator;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
