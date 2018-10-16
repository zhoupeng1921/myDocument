var http = require('http')
var server = http.createServer()

server.on('request', function(req, res) {
  //在服务器默认发送的数据，是utf-8编码的内容
  //但是浏览器不知道编码，按照当前操作系统的默认编码去解析，gbK，所以乱码
  //解决方法，告诉浏览器是什么编码
  //Content-Type 告诉对象发送的数据内容是什么类型
  res.setHeader('Content-Type', 'text/plain;charset=utf-8')
  res.end('hello 世界')
})

server.listen(4000, function() {
  console.log('Server is running...')
})
