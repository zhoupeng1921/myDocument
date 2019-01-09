# docker配置

## 1. docker info 查看docker信息

docker info   查看docker信息

## 2. docker配置文件

/etc/sysconfig/docker

OPTIONS用来控制Docker Daemon进程参数

-H: docker deamon绑定的地址 -H=unix:///var/run/docker.sock -H=tcp://0.0.0.0:2375

--registory-mirror: docker registry地址

--insecure-registry: 私有docker registry地址

--selinux-enabled: 是否开启SELinux 默认开启 

--bip：网桥docker0使用的CIDR网络地址，--bip=172.17.42.1

-b：采用已经创建好的网桥-b=xxx

设置代理：

http_proxy=xxxxx:port

https_proxy=xxxxx:port

## 3. docker日志

tail -f /var/log/messages |grep docker

