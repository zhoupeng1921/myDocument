package cn.itcast.domain;

import java.io.Serializable;

public class Person implements Serializable{
    private Integer id;
    private String name;
    private Integer age;
    private String remark;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, String remark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", remark='" + remark + '\'' +
                '}';
    }
}
