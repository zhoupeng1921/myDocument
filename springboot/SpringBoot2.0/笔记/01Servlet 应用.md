## 01Servlet 应用

- Servlet 组件：Servlet,Filter,Listener
- Servlet 注册：Servlet 注解、Spring Bean、RegistrationBean
- 异步非阻塞：异步 Servlet、非阻塞 Servlet

### Servlet 组件

- Servlet
  - 实现

    - 注解`@WebServlet` 
    - 继承`HttpServlet` 
    - 注册

  - URL 映射

    - `@WebServlet(urlPatterns = "/my/servlet")`

  - 注册

    - ```java
      @ServletComponentScan(basePackages = "com.xhx.springboot.springbootservlet.web")
      ```
- Filter

- Lisenter

#### Servlet 注解方式

- @ServletComponentScan
  - @WebServlet
  - @WebFilter
  - WebListener

#### SpringBean方式

- @Bean

  - Servlet

  - Filter

  - Lisenter


#### RegistrationBean
- ServletRegistrationBean
- FilterRegistrationBean
- ServletListenerRegistrationBean

### 异步非阻塞
- 异步Servlet

- 
