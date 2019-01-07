# nexus简介

## 1. 介绍

maven中央仓库地址：http://repo1.maven.org/maven2/

- 如果某个ip或ip段恶意或反复下载，有可能会列入列入黑名单。
- 公司内自己搭建私服

## 2. nexus安装

```shell
docker pull sonatype/nexus3
docker run -d -p 8081:8081 --name nexus -v /home/xuhaixing/nexus-data:/nexus-data sonatype/nexus3

```

 登录： ip:8081   admin/admin123

## 3. 仓库类型

`proxy`: 远程代理仓库，代理外部的仓库，连接到外部的仓库

`hosted`：宿主仓库，自己的仓库

`group`: 仓库组， 聚合多个仓库

其中

- 3rdParty 可以用来保存第三方jar
- snapshots 用来保存快照版
- release 用来保存正式版

一般情况下snapshots的Deployment policy设置为 allow redelopy