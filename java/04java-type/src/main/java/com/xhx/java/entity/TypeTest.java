package com.xhx.java.entity;

import java.util.List;

public abstract class TypeTest<T extends Number,K extends String> {
    private T id;
    private K name;
    private List<String> cloth;
    private List<String>[] students;
    private List<T> shoes;

    public List<T> getShoes() {
        return shoes;
    }

    public void setShoes(List<T> shoes) {
        this.shoes = shoes;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public K getName() {
        return name;
    }

    public void setName(K name) {
        this.name = name;
    }

    public List<String> getCloth() {
        return cloth;
    }

    public void setCloth(List<String> cloth) {
        this.cloth = cloth;
    }

    public List<String>[] getStudents() {
        return students;
    }

    public void setStudents(List<String>[] students) {
        this.students = students;
    }
}
