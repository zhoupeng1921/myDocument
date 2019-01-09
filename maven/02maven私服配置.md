# maven私服配置

## 1. 项目中配置私服地址

```xml
<repositories> 
     <repository> 
         <!--id name随便命名-->
         <id>repo1</id> 
         <name>repo1</name> 
     	 <url>http://192.168.94.151:8081/repository/maven-public/</url> 
         <snapshots> 
        	<enabled>true</enabled> 
         </snapshots> 
     </repository> 
 </repositories> 

<!-- 加载的是maven生命周期插件的jar包 --> 
 <pluginRepositories> 
     <pluginRepository> 
         <id>plugin1</id> 
         <name>plugin1</name> 
     	 <url>http://192.168.94.151:8081/repository/maven-public/</url> 
         <releases> 
             <updatePolicy>never</updatePolicy> 
             <updatePolicy>always</updatePolicy><!--jar包没有下载完会造成错误，强制更新一下--> 
         </releases> 
         <snapshots> 
             <enabled>true</enabled> 
         </snapshots> 
     </pluginRepository> 
 </pluginRepositories>
```

在根目录添加，当前项目生效

## 2. setting.xml配置私服地址

```xml
<profile>
      <id>nexusRepo</id>
      <repositories>
        <repository>
            <id>nexus</id>
            <name>nexus repository</name>
            <url>http://localhost:8081/repository/maven-public/</url>
			<releases>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</releases>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
        </repository>
	      <repository>
		  <id>central</id>
		  <name>Central Repository</name>
		  <url>https://repo.maven.apache.org/maven2</url>
		  <layout>default</layout>
		  <releases>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
		</releases>
		  <snapshots>
			<enabled>false</enabled>
		  </snapshots>
	     </repository>
	</repositories>

	<pluginRepositories>
		<pluginRepository>
		  <id>central</id>
		  <name>Central Repository</name>
		  <url>https://repo.maven.apache.org/maven2</url>
		  <layout>default</layout>
		  <snapshots>
			<enabled>false</enabled>
		  </snapshots>
		  <releases>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
		  </releases>
		</pluginRepository>
	  </pluginRepositories>
    </profile>

```

将上面的内容放到<profiles></profiles>标签中，所有用此配置的项目都生效

```xml
  <--激活一下--> 
  <activeProfiles>
	<activeProfile>nexusRepo</activeProfile>
  </activeProfiles>
```

## 3. 本地项目提交到私服中配置

```xml
 <distributionManagement>
        <repository>
            <!-- 要在个人的setting.xml中配置上传的密码 --> 
            <id>releases</id>
            <name>releases</name>
            <url>http://192.168.94.151:8081/repository/maven-releases/</url>
        </repository>
        <snapshotRepository>
            <id>snapshots</id>
            <name>snapshots</name>
            <url>http://192.168.94.151:8081/repository/maven-snapshots/</url>
        </snapshotRepository>
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


## 4. maven命令上传第三方jar包

```shell
mvn deploy:deploy-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar -Dfile=ojdbc6.jar -Durl=http://localhost:8081/repository/3rdParty/  -DrepositoryId=3rdParty
```

