# 两种代理讲解

## jdk代理

- 实现类

  `InvocationHandler `

- 重写方法

  `invoke`

- 调用方式

  `Proxy.newProxyInstance()`



- 样例

  ```java
  package com.xhx.java;
  
  import java.lang.reflect.InvocationHandler;
  import java.lang.reflect.Method;
  
  public class VehicalInvacationHandler implements InvocationHandler {
  
      private final IVehical vehical;
      public VehicalInvacationHandler(IVehical vehical){
          this.vehical = vehical;
      }
  
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          System.out.println("---------before-------");
          Object invoke = method.invoke(vehical, args);
          System.out.println("---------after-------");
  
          return invoke;
      }
  }
  ```


```java
package com.xhx.java;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        IVehical car = new Car();

        IVehical vehical = (IVehical)Proxy.newProxyInstance(car.getClass().getClassLoader(), Car.class.getInterfaces(), new VehicalInvacationHandler(car));
        vehical.run();
        System.out.println(vehical.getClass());
    }
}

```



## cglib代理

- 实现类

  `MethodInterceptor `

- 重写方法

  `intercept`

- 调用方式

  `生成Enhancer对象`

- 样例

  重写方法

  ```java
  package com.xhx.java;
  
  import net.sf.cglib.proxy.Enhancer;
  import net.sf.cglib.proxy.MethodInterceptor;
  import net.sf.cglib.proxy.MethodProxy;
  
  import java.lang.reflect.Method;
  import java.util.Objects;
  
  public class HelloProxy implements MethodInterceptor {
  
      /**
       * 接口的回调方法
       * @param o  cglib生成的代理对象
       * @param method  被代理的方法
       * @param objects 方法入参
       * @param methodProxy 代理方法
       * @return
       * @throws Throwable
       */
      public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
          System.out.println("前");
  
          Object result = methodProxy.invokeSuper(o, objects);
  
          //这种方法相当于一直调用代理类的方法，就会一直回调，造成死循环
          //Object rest = methodProxy.invoke(o,objects);
          System.out.println("后");
          return result;
      }
  
  }
  
  ```

  构建Enhancer

  ```java
  package com.xhx.java;
  
  import net.sf.cglib.proxy.Callback;
  import net.sf.cglib.proxy.Enhancer;
  
  public class ProxyBuilder {
      public static Object getHelloProxy(Class clazz, Callback callback) {
          Enhancer enhancer = new Enhancer();
          //设置父类
          enhancer.setSuperclass(clazz);
          //设置回调类 拦截方法  MethodInterceptor的 intercept方法
          enhancer.setCallback(callback);
          //生成代理对象
          return enhancer.create();
      }
  }
  
  ```



  调用

   ```java
  package com.xhx.java;
  
  public class App {
  
      public static void main(String[] args) {
          Hello hello = (Hello)ProxyBuilder.getHelloProxy(Hello.class, new HelloProxy());
          hello.say();
      }
  }
  
   ```
