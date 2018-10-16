var http = require('http')

var server = http.createServer()

//request请求事件处理函数，需要接收两个参数
//  Request对象
//  Response对象
server.on('request', function(request, response) {
  console.log('收到请求了,请求路径:' + request.url) //返回端口号后面的路径

  // response对象有一个方法write,可以给客户端发送响应数据，可以使用多次，最后一定要用end来结束响应，发送到前端
  response.write('hello')
  response.write('world')
  response.end()
})

server.listen(3000, function() {
  console.log('服务器启动成功了')
})
