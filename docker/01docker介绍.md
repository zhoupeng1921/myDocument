# docker介绍

## 1. 容器与Docker

什么是容器：

- 一种虚拟化方案
- 操作系统级别的虚拟化
- 只能运行相同或相似内核的操作系统
- 依赖于linux内核特征：Namespace和Cgroups(Control Group)

什么是docker:

- 一种虚拟化的轻量级代替技术，docker的容器技术不依赖于任何语言、框架或系统，可以将APP变成一种标准化的、可移植的、自管理的组件，并脱离服务器硬件在任何主流系统中开发、调试和运行

docker的目标：

- 提供简单轻量的建模方式
- 职责的逻辑分离
- 快速高效的开发生命周期
- 鼓励面向服务的架构

## 2. docker的使用场景

- 使用docker容器开发、测试、部署服务
- 创建隔离的运行环境
- 搭建测试环境
- 构建多用户的平台即服务（paas）基础设施
- 供软件即服务（SaaS）应用程序
- 高性能、超大规模的宿主机部署
- 面向产品 面向开发 面向测试 面向运维 面向自动化 面向微服务 面向大规模分布式架构

## 3. docker基本组成

- Docker Client客户端
- Docker Daemon守护进程
- Docker Image镜像
- Docker Container容器
- Docker Registry仓库

## 4. docker依赖的Linux内核特征

- Namespaces命名空间
  - PID(Process ID) 进程隔离
  - NET(Network) 管理网络接口
  - IPC(InterProcessCommunication) 管理跨进程通信的访问
  - MNT(Mount) 管理挂载点
  - UTS(Unix Timesharing System) 隔离内核和版本标识

- Control Groups控制组 来源于谷歌
  - 资源限制
  - 优先级设定
  - 资源计量
  - 资源控制

## 5. docker容器的能力

- 文件系统隔离 每个容器都有自己的root文件系统
- 进程隔离 每个容器都运行在自己的进程环境中
- 网络隔离 容器间的虚拟网络接口和ip地址都是分开的
- 资源隔离和分组：使用cgroups将cpu和内存之类的资源独立分配给每个Docker容器

