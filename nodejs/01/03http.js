//node中提供了一个核心模块: http，用来创建服务器
//1.加载http模块
var http = require('http')

//2.创建一个web服务器，返回一个Server实例
var server = http.createServer()

//3.发请求 接收请求 处理请求 发送响应
//注册request请求事件，请求触发时，执行第二个参数，回调函数
server.on('request', function() {
  console.log('收到请求了')
})

//4.绑定端口号，启动服务器
server.listen(3000, function() {
  console.log('服务器启动成功了')
})
