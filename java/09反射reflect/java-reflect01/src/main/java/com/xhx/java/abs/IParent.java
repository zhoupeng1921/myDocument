package com.xhx.java.abs;

public interface IParent {
    String id = "1245";
    default String getString(){
        return "abcd";
    }
}
