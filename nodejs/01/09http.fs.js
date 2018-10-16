var http = require('http')
var fs = require('fs')

var server = http.createServer()

server.on('request', function(req, res) {
  var url = req.url
  if (url === '/') {
    fs.readFile('./resource/index.html', function(err, data) {
      if (err) {
        res.setHeader('Content-Type', 'text/plain;chartset=utf-8')
        res.end('文件读取失败')
      } else {
        //res.end支持两种类型 字符串/二进制
        res.setHeader('Content-Type', 'text/html;chartset=utf-8')
        res.end(data)
      }
    })
  }
})

server.listen(4000, function() {
  console.log('Server is running...')
})
