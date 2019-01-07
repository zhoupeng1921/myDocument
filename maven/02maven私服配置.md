# maven私服配置

## 1. 项目中配置私服地址

```xml
<repositories> 
     <repository> 
         <!--id name随便命名-->
         <id>repo1</id> 
         <name>repo1</name> 
     	 <url>http://192.168.94.151:8081/repository/maven-public/</url> 
     </repository> 
 </repositories> 

 <pluginRepositories> 
     <pluginRepository> 
         <id>plugin1</id> 
         <name>plugin1</name> 
     	 <url>http://192.168.94.151:8081/repository/maven-public/</url> 
     </pluginRepository> 
 </pluginRepositories>
```

当前项目生效

## 2. setting.xml配置私服地址

将上面的内容放到<profiles></profiles>标签中，所有用此配置的项目都生效

## 3. 本地项目提交到私服中配置

```xml
<distributionManagement> 
    <repository> 
        <!-- 要在个人的setting.xml中配置上传的密码 --> 
        <id>snapshots</id> 
        <name>snapshots 测试版</name> 
        <!-- nexus中相应的地址--> 
        <url>http://192.168.94.151:8081/repository/maven-snapshots/</url> 
    </repository> 
</distributionManagement> 



<!-- 在setting.xml中 配置要上传仓库的密码 --> 
<servers>
	<server> 
        <!--id与上面配置的id要一致-->
        <id>snapshots</id> 
        <username>admin</username> 
        <password>admin123</password> 
    </server> 
    <server> 
        <id>releases</id> 
        <username>admin</username> 
        <password>admin123</password> 
    </server> 
</servers>
```

