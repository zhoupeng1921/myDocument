# EventLisenter

spring自带事件功能，继承自jdk中的事件，事件其实是用的观察者设计模式，spring容器在启动时，把所有的lisenter存起来，当发布事件时，再循环lisenter集合，然后调用。

写一个事件发布者，MyEvent是我自己定的一个实体类，代表事件的主体，注入ApplicationContext，ApplicationContext继承了ApplicationEventPublisher，真正的实现在org.springframework.context.support.AbstractApplicationContext这个类中。

```java
@Component
public class MyPublisher{

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 自己定义的发布事件 用ApplicationContext发布
     * @param myEvent
     */
    public void publisMess(MyEvent myEvent){
        applicationContext.publishEvent(myEvent);
    }
}
```


源码中有两个方法，spring4.2以后，发布事件可以不用继承ApplicationEvent，可以用任意类型当事件

```
    public void publishEvent(ApplicationEvent event) {
        this.publishEvent(event, (ResolvableType)null);
    }

    public void publishEvent(Object event) {
        this.publishEvent(event, (ResolvableType)null);
    }
```


我的事件实体继承了ApplicationEvent，重写了构造方法，把我自己定义的EventBody实体传了进去

```java
/**
 * spring事件要继承ApplicationEvent，它继承的jdk的事件EventObject
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
```


```java
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
```



接收事件有两种方法

1.传统方法继承ApplicationListener\<E extends ApplicationEvent> 这个类。

```java
@Component
public class EvenLisenterConfig implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("接收到事件了1");
    }
}
```

2.用EventListener注解，如果不需要参数，事件也可以不用放在方法参数中，在@EventListener中指定类型也可以。

```java
@Component
public class AnnoEventLisenterConfig {

    @EventListener(MyEvent.class)
    public void myEventLisenter2(){
        System.out.println("接收到事件了2");
    }

    @Async
    @EventListener
    public void myEventLisenter3(MyEvent myEvent){
        System.out.println(myEvent.getEventBody().toString());
    }
}
```


 @Async是做了异步。

方法中也可以加入返回参数，如果有返回参数，返回参数也会当事件发布出去。

EventListener源码如下，还可以用SpEL表达式

```java
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EventListener {

	/**
	 * Alias for {@link #classes}.
	 */
	@AliasFor("classes")
	Class<?>[] value() default {};

	/**
	 * The event classes that this listener handles.
	 * <p>If this attribute is specified with a single value, the
	 * annotated method may optionally accept a single parameter.
	 * However, if this attribute is specified with multiple values,
	 * the annotated method must <em>not</em> declare any parameters.
	 */
	@AliasFor("value")
	Class<?>[] classes() default {};

	/**
	 * Spring Expression Language (SpEL) attribute used for making the
	 * event handling conditional.
	 * <p>Default is {@code ""}, meaning the event is always handled.
	 * <p>The SpEL expression evaluates against a dedicated context that
	 * provides the following meta-data:
	 * <ul>
	 * <li>{@code #root.event}, {@code #root.args} for
	 * references to the {@link ApplicationEvent} and method arguments
	 * respectively.</li>
	 * <li>Method arguments can be accessed by index. For instance the
	 * first argument can be accessed via {@code #root.args[0]}, {@code #p0}
	 * or {@code #a0}. Arguments can also be accessed by name if that
	 * information is available.</li>
	 * </ul>
	 */
	String condition() default "";

}
```
