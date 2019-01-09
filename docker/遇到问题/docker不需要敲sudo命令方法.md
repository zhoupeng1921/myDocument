由于docker daemon需要绑定到主机的Unix socket而不是普通的TCP端口，而Unix socket的属主为root用户，所以其他用户只有在命令前添加sudo选项才能执行相关操作。

如果不想每次使用docker命令的时候还要额外的敲一下sudo，可以按照下面的方法配置一下。

1. 创建一个docker组 

   $ sudo groupadd docker 

 

1. 添加当前用户到docker组 

   $ sudo usermod -aG docker $USER 

 

1. 登出，重新登录shell

2. 验证docker命令是否可以运行 

   $ docker run hello-world 