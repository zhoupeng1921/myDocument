使用docker-compose，启动的容器默认是用的root权限，但是docker中的root只是相当于普通用户

所以需要给挂载的目录或者文件开启权限，代码如下：

```
#开启目录权限
chmod a+rwx 目录

#开启docker挂载权限
chmod a+rw /var/run/docker.sock 
```

