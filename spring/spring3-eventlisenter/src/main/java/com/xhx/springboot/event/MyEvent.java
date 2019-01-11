package com.xhx.springboot.event;

import com.xhx.springboot.entity.EventBody;
import org.springframework.context.ApplicationEvent;

/**
 * spring事件要继承ApplicationEvent，它继承的jdk的事件EventObject
 *
 * spring4.2以后，发布事件可以不用继承ApplicationEvent，可以用任意类型当事件
 */
public class MyEvent extends ApplicationEvent {
    private EventBody eventBody;

    public EventBody getEventBody() {
        return eventBody;
    }

    public void setEventBody(EventBody eventBody) {
        this.eventBody = eventBody;
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(EventBody source) {
        super(source);
        this.eventBody = source;
    }
}
