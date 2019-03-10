1. show engines;

   查看数据库引擎，默认的有default

2. 修改数据库引擎

   1. my.cnf，加上default-storage-engine=InnoDB
   2. 建表时指定ENGINE=InnoDB
   3. alter table account engine=InnoDB; 

3. show create table account; 查看结果