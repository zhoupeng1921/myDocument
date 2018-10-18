var express = require('express')
var app = express()

app.get('/', function(req, res) {
  res.write('hello')
  res.write('world')
  res.end()
})

app.listen(4000, function() {
  console.log('Server is running...')
})

//解决频繁修改代码重启服务器问题
// npm install --global nodemon
//nodemon xxx.js 启动
