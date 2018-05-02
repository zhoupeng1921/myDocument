package com.xhx.springboot.entity;

/**
 * @author xuhaixing
 * @date 2018/4/28 10:29
 */
public class Account {
    private int id;
    private String name;
    private Double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
