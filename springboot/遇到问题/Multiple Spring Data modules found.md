## Multiple Spring Data modules found, entering strict repository configuration mode!

启动时遇到这个`INFO`信息

redis/jdbc/jpa/mongo等模块，都继承spring-data，同时引入两个repository，启动时repository的接口会生成多份bean。

解决方法：

1. 指定扫描包

   ```java
   @EnableMongoRepositories(basePackages = "com.acme.repositories.mongo")
   @EnableJpaRepositories(basePackages = "com.acme.repositories.jpa")
   ```

2. 若用不到repository可以直接关闭

   ```properties
   spring.data.redis.repositories.enabled=false
   ```
