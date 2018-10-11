package com.xhx.spring.entity;

import com.xhx.spring.interfaces.New;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull(groups = {New.class})
    private String id;
    @NotNull
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
