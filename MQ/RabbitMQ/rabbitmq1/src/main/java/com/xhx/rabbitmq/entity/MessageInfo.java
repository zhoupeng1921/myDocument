package com.xhx.rabbitmq.entity;

import java.io.Serializable;

/**
 * xuhaixing
 * 2018/5/14 15:55
 */
public class MessageInfo implements Serializable {
    private String channel;
    private String content;
    private int hashCode;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "channel='" + channel + '\'' +
                ", content='" + content + '\'' +
                ", hashCode=" + hashCode +
                '}';
    }
}
