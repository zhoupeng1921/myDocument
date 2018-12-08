# ActiveMQ启动配置

## 启动

1. 官网下载并解压到指定目录

2. 进不到ACTIVEMQ_HOME/bin目录，启动 sudo sh activemq start，会报一个错误

   ```
   NFO: Loading '/usr/local/apache-activemq-5.15.8//bin/env'
   ERROR: Configuration variable JAVA_HOME or JAVACMD is not defined correctly.
          (JAVA_HOME='', JAVACMD='java')
   
   ```

   - `sudo vi activemq`加入`JAVA_HOME='/usr/local/java/jdk1.8.0_144/'`，再重新启动，成功

3. 创建开机自动启动

   1. 自己在`etc/init.d`下写一个脚本

      ```shell
      #!/bin/sh
      
      ### BEGIN INIT INFO
      # Provides:          activemq
      # Required-Start:    $remote_fs $network $syslog
      # Required-Stop:     $remote_fs $network $syslog
      # Default-Start:     3 5
      # Default-Stop:      0 1 6
      # Short-Description: Starts ActiveMQ
      # chkconfig: 2345 64 36
      # Description:       Starts ActiveMQ Message Broker Server
      ### END INIT INFO
      export ACTIVEMQ_HOME=/usr/local/apache-activemq-5.15.8/
      case $1 in
      	start)
      		sh $ACTIVEMQ_HOME/bin/activemq start
      	;;
      	stop)
      		sh $ACTIVEMQ_HOME/bin/activemq stop
      	;;
      	restart)
      		sh $ACTIVEMQ_HOME/bin/activemq restart
      	;;
      esac
      exit 0
      
      ```

   2. 设置开机自动自动`chkconfig activemq on`

   3. 启动服务`systemctl start activemq`

   4. 打开访问控制台的端口号8161`sudo firewall-cmd --zone=public --add-port=8161/tcp --permanent`

   5. 访问地址`http://192.168.94.151:8161/admin/` 默认用户名密码admin/admin

