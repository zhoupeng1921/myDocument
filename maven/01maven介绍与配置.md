# maven介绍与配置

## 1. 介绍

Maven是一个采用java编写的开源项目管理工具，采用一种被称之为Project Object Model（pom）概念来管理项目，所有的项目信息都被定义在一个叫pom.xml的文件中，通过该文件，maven可以管理项目整个生命周期，包括清除、编译、测试、报告、打包、部署等。

## 2. maven能做什么

- jar包的声明式依赖性管理
- 项目生命周期

## 3. pom介绍

`modelVersion`： 当前pom版本号

`groupId`：当前jar命名空间

`artifactId`： 当前模块名称

`version`：当前项目版本  -SNAPSHOT为快照版

`dependencies`：当前项目依赖的jar包

`properties`：可以配置常量 ${}引用

## 4. 常用命令

`mvn clean`

`mvn compile`

`mvn test`

`mvn package`

`mvn install`

`mvn deploy`

## 5. maven核心概念

### 5.1 插件

maven仅仅定义了生命周期，具体任务是交由插件完成的，每个插件都能实现多个功能，每个功能就是一个插件目标，maven插件在`.m2\repository\org\apache\maven\plugins `

### 5.2 坐标

`groupId` `artifactId` `version`唯一定位一个jar包

jar包的路径 `groupId/artifactId/version/artifactId-version `

## 6. 跳过单元测试

```shell
mvn install -D maven.test.skip=true 
```

也可以用surefire插件

```xml
<build> 
    <plugins> 
        <plugin> 
            <artifactId>maven-surefire-plugin</artifactId> 
            <version>2.7.1</version> 
            <configuration> 
            	<skip>true</skip> 
            </configuration> 
        </plugin> 
    </plugins> 
</build>
```

## 7. 快速构建项目

```shell
mvn archetype:create -D groupId=com.test.maven -D artifactId=test1 -D packageName=a.b.c 
```

archetype可以快速构建项目框架