# 聚合与继承

## 1. 聚合

​     当定义多个maven项目的时候，需要对这些项目进行打包编译，一一操作会很繁琐。maven的聚合就是为了解决这个问题，只执行一次打包编译，所有项目都有效。

​    <packaging>pom</packaging>选择pom，意思是该项目作为管理项目，还有两个值jar,war。

   在pom.xml中使用modules标签对项目进行聚合操作：相对路径

```xml
<modules>  
    <module>../xxx_log</module>  
    <module>../xxx_service</module>  
    <module>../xxx_core</module>  
</modules> 
```

## 2. 继承

​        解决每个项目依赖问题，每个项目的pom里都有大量的重复。让每个项目都继承一个根类，在根类里面配置依赖，这样不仅不需要对项目进行重复的依赖配置，而且能对依赖进行统一的管理。这就是maven中jar包依赖的继承。

​       选择<packaging>pom</packaging>,作为根类项目管理，子类项目要使用根类项目的依赖时使用parent标签实现继承。相对路径

```xml
<parent>  
    <groupId>com.carlo</groupId>  
    <artifactId>xxx_parent</artifactId>  
    <version>0.0.1-SNAPSHOT</version>
    <relativePath>../xxx_parent/pom.xml</relativePath>  
</parent>  
```

​         在根类定义依赖的时候，不能直接使用<dependencies></dependencies>,如果根类使用这种方式声明依赖的话，在所有子类中，都会直接继承这个依赖。然而并不是每个子类都需要这个依赖。

​       在根类中使用依赖管理的标签<dependencyManagement></dependencyManagement>来管理依赖，这种方式不会直接被子类项目继承。

​      因为在根类项目中已经声明了依赖的版本号和作用域，所以子类项目想使用到某个依赖时只需要在自己项目的pom.xml中声明goupId和artifactId,就会从根类项目中继承获取到对应的依赖。

##  3. 代码

pom根类： 

```x&#39;m&#39;l
 <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 <http://maven.apache.org/xsd/maven-4.0.0.xsd>">  

      <modelVersion>4.0.0</modelVersion>  
      <groupId>com.carlo</groupId>  
      <artifactId>xxx_parent</artifactId>  
      <version>0.0.1-SNAPSHOT</version>  
      <packaging>pom</packaging>  
  
     
      <!-- 聚合 -->  
      <modules>  
        <module>../xxx_log</module>  
        <module>../xxx_service</module>  
        <module>../xxx_core</module>  
      </modules> 
      
     
      <url>http://maven.apache.org</url>  
      <properties>  
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
      </properties> 
       <!-- 继承的包 -->  
      <dependencyManagement>  
        <dependencies>  
           <dependency>  
              <groupId>junit</groupId>  
              <artifactId>junit</artifactId>  
              <version>3.8.1</version>  
              <scope>test</scope>  
            </dependency>               
            <dependency>  
              <groupId>xx</groupId>  
              <artifactId>yyy</artifactId>  
              <version>0.0.1</version>  
              <exclusions>  
               <exclusion>  
                   <groupId>aa</groupId>  
                   <artifactId>bb</artifactId> 
                </exclusion>  
              </exclusions>  
            </dependency>  
        </dependencies>       
       </dependencyManagement>  
    </project>  

 
```

 

pom子类：

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
      <modelVersion>4.0.0</modelVersion>  
    	<!--继承-->
        <parent>  
            <groupId>com.carlo</groupId>  
            <artifactId>xxx_parent</artifactId>  
            <version>0.0.1-SNAPSHOT</version>  
            <relativePath>../xxx_parent/pom.xml</relativePath>  
        </parent>  
      
      <artifactId>xxx_log</artifactId>  
      <packaging>jar</packaging> 
      <name>xxx_log</name> 
      <dependencies>  
          <dependency>  
              <groupId>junit</groupId>  
              <artifactId>junit</artifactId>  
          </dependency> 
          <dependency>  
              <groupId>xx</groupId>  
              <artifactId>yyy</artifactId>  
          </dependency>  
      </dependencies>  
    </project>  


```

 

 

 