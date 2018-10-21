var mysql = require('mysql')

// 1. 创建连接
var connection = mysql.createConnection({
  host: '192.168.94.151',
  user: 'root',
  password: 'root',
  database: 'mytest'
})

// 2. 连接数据库
connection.connect()

// 3. 查询
connection.query('SELECT * FROM `users`', function(error, results, fields) {
  if (error) {
    throw error
  }
  console.log(results)
})

//4. 插入
connection.query('INSERT INTO users VALUES(NULL, "admin", "123456")', function(
  error,
  results,
  fields
) {
  if (error) {
    throw error
  }
  console.log('The solution is: ', results)
})

// 4. 关闭连接
connection.end()
