使用docker-compose，启动的容器默认是用的root权限，但是docker中的root只是相当于普通用户

所以需要给挂载的目录或者文件开启权限，代码如下：

```
#开启目录权限
chmod a+rwx 目录

#开启docker挂载权限
chmod a+rw /var/run/docker.sock 
```



centos7中安全模块selinux把权限禁掉了。

有三种方法解决：
​    1.在运行时加 --privileged=true 

[xuhaixing@localhost tomcat]$ docker run -d -p 9091:8080 -v /home/xuhaixing/docker/tomcat/webapps/:/usr/local/tomcat/webapps/ --privileged=true --name managertomcat xuhaixing/mytomcat
c512137b74f3366da73ff80fc1fd232cc76c95b52a4bab01f1f5d89d28185b28
[xuhaixing@localhost tomcat]$ ls

2.临时关闭selinux然后再打开

[root@localhost tomcat]# setenforce 0
[root@localhost tomcat]# setenforce 1


3.添加linux规则，把要挂载的目录添加到selinux白名单

# 更改安全性文本的格式如下
chcon [-R] [-t type] [-u user] [-r role] 文件或者目录

选顷不参数： 
-R  ：该目录下的所有目录也同时修改； 
-t  ：后面接安全性本文的类型字段，例如 httpd_sys_content_t ； 
-u  ：后面接身份识别，例如 system_u； 
-r  ：后面街觇色，例如 system_r
--------------------- 
作者：徐海兴 
来源：CSDN 
原文：https://blog.csdn.net/u012326462/article/details/81038446 
版权声明：本文为博主原创文章，转载请附上博文链接！