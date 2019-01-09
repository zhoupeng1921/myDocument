# dependency

## 1. 排除依赖

```x&#39;m&#39;l
	<!--排除依赖，不需要写version，因为每个项目都只依赖某一版本的某一个包，所以在配置排除依赖的时候，不需要加上版本号了-->  
	<exclusions>  
		<exclusion>  
			<groupId>org.zzz</groupId>  
			<artifactId>bb</artifactId>  
		</exclusion>  
	</exclusions> 
```

