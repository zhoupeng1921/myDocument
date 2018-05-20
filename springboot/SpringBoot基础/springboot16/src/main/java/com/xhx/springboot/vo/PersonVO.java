package com.xhx.springboot.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * xuhaixing
 * 2018/5/19 21:42
 */
public class PersonVO {

    @NotNull
    @Size(min = 2,max = 40)
    private String name;


    @NotNull
    @Min(18)
    private Integer age;

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
