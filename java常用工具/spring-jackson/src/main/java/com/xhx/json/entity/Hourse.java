package com.xhx.json.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xhx.json.serializers.HourseSerializer;

import java.util.Date;

@JsonSerialize(using = HourseSerializer.class)
public class Hourse {
    private String location;
    private Date buildDate;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }
}
