# mysql常用命令

- 创建数据库
  - `create database mytestdb character set utf8;` --指定编码

- 创建用户
  - `create user testuser identified by '1234'` 

- 授权
  - `grant all on mytestdb.* to testuser` --赋予某个数据库权限

- 关闭自动提交
  - `set autocommit=0`