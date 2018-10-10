package com.xhx.json.entity2;


import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @JsonSubTypes  解决多态的反序列化类型问题
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,include = JsonTypeInfo.As.PROPERTY,property = "@Clazz")
//@JsonSubTypes({@JsonSubTypes.Type(value = Lion.class,name = "lion"),@JsonSubTypes.Type(value = Tiger.class,name = "tiger")})
public abstract class Animal {
    protected String name;
    protected Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
