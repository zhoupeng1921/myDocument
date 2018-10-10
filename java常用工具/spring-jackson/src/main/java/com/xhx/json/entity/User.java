package com.xhx.json.entity;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.Date;

/**
 * xuhaixing
 * 2018/10/9 21:29
 **/

/**
 * @JsonInclude  value某些属性是否序列化的规则
 * @JsonRootName  需要设置mapper.enable(SerializationFeature.WRAP_ROOT_VALUE); 否则rootName无效
 * @JsonIgnoreProperties 设置不被序列化的属性
 */
@JsonIgnoreProperties(value = {"money"})
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@JsonRootName(value = "root")
public class User {
    private String id;

    /**
     * @JsonProperty
     * value 可以改变序列化和反序列化时属性的名称
     * access 控制是否可以被序列号或者反序列化
     */
//    @JsonProperty(value = "fullName",access = JsonProperty.Access.READ_ONLY)
    @JsonProperty(value = "fullName")
    private String name;

    /**
     * @JsonValue 若加上这个字段则序列化只输出这个值
     */
    private Integer age;
    /**
     *  @JsonIgnore 忽略这个属性不转换
     */
    @JsonIgnore
    private LocalDate birthday;
    private Double money;

    private String compute;

    /**
     * @JsonFormat pattern做格式转换
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy年MM月dd日 HH:mm:ss",timezone ="GMT+8")
    private Date date;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date date2;

    @JsonFormat(shape = JsonFormat.Shape.STRING,locale = "zh_CN")
    private Date date3;

    public String getId() {
        return id;
    }
    /**
     *
     * Jackson作用于json，没有getId,不会序列化id
     */
//    public String getId() {
//        return id;
//    }

    public void setId(String id) {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompute() {
        return compute;
    }

    public void setCompute(String compute) {
        this.compute = compute;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", money=" + money +
                ", date=" + date +
                '}';
    }
}
