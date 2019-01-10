package com.xhx.java.entity;

public class Domain {
    public Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    private String contact(String a, String b){
        return a+b;
    }
}
