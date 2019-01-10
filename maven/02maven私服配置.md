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

releases和snapshots标签中可设置的选项：

- enabled，true或者false表示该仓库是否为下载某种类型构件（发布版，快照版）开启。
- updatePolicy，该元素指定更新包的频率。可选值有daily, always, never,      interval:X(其中的X是一个数字，表示间隔的时间，单位min)，默认为daily。Maven会比较本地POM和远程POM的时间戳。这里的选项是：always（一直），daily（默认，每日），interval：X（这里X是以分钟为单位的时间间隔），或者never（从不）。
- checksumPolicy，校验码异常的策略，可选值有ignore, fail, warn。当Maven验证构件校验文件失败时该怎么做-ignore（忽略），fail（失败），或者warn（警告）。



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

setting.xml中配置<server>标签进行授权，server里的id对应<distributionManagement>里设置的id。当执行deploy命令进行发布时，首先会找到<distributionManagement>的配置，获取配置信息。

然后如果setting.xml里有配置server，对比id值，如果匹配的上，就验证server里的用户是否拥有发布的权限，有权限就把项目发布到对应的仓库里。

## 4. maven命令上传第三方jar包

```shell
mvn deploy:deploy-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar -Dfile=ojdbc6.jar -Durl=http://localhost:8081/repository/3rdParty/  -DrepositoryId=3rdParty
```

