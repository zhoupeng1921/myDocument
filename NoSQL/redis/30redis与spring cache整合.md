# redis与spring -cache整合

spring-cache使用CacheManager来管理缓存，需要用redis作为缓存源整合到CacheManager。

```java
    @Bean
   public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(3000);//s
//        redisCacheManager.setExpires(new HashMap<>());
        return redisCacheManager;
    }
```

`setDefaultExpiration`: 设置默认过期时间

`setExpires`: 接收一个map，key为redis的key，value为过期时间