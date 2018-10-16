var http = require('http')

var server = http.createServer()

server.on('request', function(req, res) {
  console.log('收到请求，路径是：' + req.url)
  // res.write('hello')
  // res.write('world')
  // res.end()

  //这样更简单
  // res.end('hello world')

  //获取到的url是端口号的后面  /开头的路径
  var url = req.url
  if (url === '/') {
    res.end('index page')
  } else if (url === '/login') {
    res.end('login html')
  } else {
    res.end('404 not found.')
  }
  //返回到前端的参数，必须是字符串或者二进制，不能是其它类型
})

server.listen(4000, function() {
  console.log('服务器启动成功')
})
