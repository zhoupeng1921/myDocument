指定密码,端口,数据挂在地址

docker run --name mysql3306 -v /home/xuhaixing/msql/data:/var/lib/mysql -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=xuhaixing mysql    

 

查看端口：

​    netstat -tlp