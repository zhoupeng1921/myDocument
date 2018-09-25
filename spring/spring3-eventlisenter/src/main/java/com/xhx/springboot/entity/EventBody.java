package com.xhx.springboot.entity;

public class EventBody {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EventBody() {
    }

    public EventBody(String name, String message) {
        this.name = name;
        this.message = message;
    }

    @Override
    public String toString() {
        return "EventBody{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
